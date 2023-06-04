import React, {useEffect, useState} from 'react';
import LocalDiningIcon from "@mui/icons-material/LocalDining";
import './ChoosenRestaurant.css'
import CardsItem from "../../../../AllCards/CardsItem/CardsItem";
import {v4 as uuidv4} from "uuid";
import {useLocation, useNavigate, useParams} from "react-router-dom";
import Basket from "../../../../Basket/Basket";
import CatalogBar from "../../../../UI/CatalogBar/CatalogBar";
import basketMobX from '../../../../../Store/basketMobX'
import {observer} from "mobx-react-lite";
import login from "../../../LoginPage/Login/Login";
import Content from "./content/Content";
import Catalog from "./catalog/Catalog";

const ChoosenRestaurant = observer(() => {
    const navigate = useNavigate()

    function navigateToMainPage() {
        navigate('/')
    }

    const [categories, setCategories] = useState([{}]);
    const [restaurantInfo, setRestaurantInfo] = useState({});
    const {id} = useParams()
    const location = useLocation()

    function getRestaurantInfo() {
        return fetch("http://localhost:8080/restaurants/info", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({id})
        }).then(res => res.json())
    }

    useEffect(() => {
        Promise.all([getRestaurantInfo(), getCateg()]).then(([restaurantInformationFromPromise, categoriesFromPromise]) => {
            setCategories(categoriesFromPromise)
            setRestaurantInfo(restaurantInformationFromPromise)
            const menu_items_category = []
            restaurantInformationFromPromise?.menu_items?.map(item => {
                menu_items_category.push(item.menu_category_id)
            })
            setCategories(categoriesFromPromise.filter((item) => menu_items_category.includes(item.id)))
        })
            .catch(error => console.log(error))
    }, [])


    function getCateg() {
        return fetch("http://localhost:8080/menuCategory", {}).then(res => res.json())
    }

    const [categoryID,setCategoryID] = useState()

    return (
        <>
            <div className='UpBarIcon' style={{borderBottom: '1px solid #D2D0CC', display: "flex", cursor: "pointer"}}
                 onClick={navigateToMainPage}>Еда <LocalDiningIcon/> Ашот
            </div>
            <div className="container">

                <Catalog categories={categories} setCategoryID={setCategoryID} />

                <Content restaurantInfo={restaurantInfo} categoryID={categoryID}/>

                <Basket/>

            </div>

        </>
    );
});

export default ChoosenRestaurant;