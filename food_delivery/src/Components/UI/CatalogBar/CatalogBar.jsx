import React, {useEffect, useState} from 'react';
import './CatalogBar.css'
import CardsItem from "../../AllCards/CardsItem/CardsItem";
const CatalogBar = ({setCategoriesID}) => {

    function setCateg(newId){
        setCategoriesID((prevCategories) => [...prevCategories,newId])
    }


    const [categories,setCategories] = useState([]);
    useEffect(() => {
        fetch("http://localhost:8080/menuCategory", {

        }).then(res => res.json() ).then(res => {setCategories(res);
            })
    } ,[]);
    return (
        <div>
            <ul className='Catalog'>
                {categories.map((category) => (
                    <li className='Catalog_item' key={category.id} onClick={() => {
                        setCateg(category.id)
                    }}>{category.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default CatalogBar;