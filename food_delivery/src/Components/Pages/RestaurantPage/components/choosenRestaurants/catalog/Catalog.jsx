import React from 'react';
import './Catalog.css'
const Catalog = ({categories, setCategoryID}) => {
    return (
        <ul className='catalog'>
            {categories?.map((category) => (
                <li className='catalog_item' key={category.id} onClick={() => setCategoryID(category.id)}>{category.name}</li>
            ))}
            <li className='catalog_item' onClick={()=>setCategoryID()}>Показать все</li>
        </ul>
    );
};

export default Catalog;