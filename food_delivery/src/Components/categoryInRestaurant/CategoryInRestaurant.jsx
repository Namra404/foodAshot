import React, {useState} from 'react';
import './CategoryInRestaurant.css'
const CategoryInRestaurant = ({setCategoriesID}) => {

    const [categories,setCategories] = useState([]);

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

export default CategoryInRestaurant;