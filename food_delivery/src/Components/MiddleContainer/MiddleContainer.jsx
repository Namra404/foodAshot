import React, {useState} from 'react';
import './MiddleContainer.css'
import CatalogBar from "../UI/CatalogBar/CatalogBar";
import MySelect from "../UI/MySelect/MySelect";
import SortButton from "../UI/SortButton/SortButton";
import Cards from "../AllCards/Cards/Cards";
import RestaurantsCards from "../AllCards/RestaurantsCards/RestaurantsCards";
import basketMobX from "../../Store/basketMobX";
import {observer} from "mobx-react-lite";


const MiddleContainer = observer( () => {
    const [categoriesID,setCategoriesID] = useState([]);
    return (
        <div className='middleContainer'>
            <h2 style={{marginTop:"100px"}}> Рестораны</h2>
            <div className='filter_bar'>
                <CatalogBar setCategoriesID={setCategoriesID}/>
                <SortButton setCategoriesID={setCategoriesID}/>
            </div>
            <h2>Все рестораны</h2>
            <div className='resCards'>
                <RestaurantsCards categoriesID={categoriesID} onClick={() => basketMobX.clearRestaurant()}/>
            </div>
        </div>
    );
});

export default MiddleContainer;