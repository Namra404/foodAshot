import React from 'react';
import './MenuItemCard.css'
import MyButton from "../../UI/button/MyButton";
const MenuItemCard = ({img, name, description, action = '', onClick ,price}) => {
    return (
        <div className='resCard' >
            <img src={img} className='menuItemIMG' />
            <h6>{name}</h6>
            <div className="cardDescription">{description}</div>
            <div>{price} ₽</div>
            {action && <MyButton children={action} onClick={onClick} ></MyButton>}
        </div>
    );
};

export default MenuItemCard;