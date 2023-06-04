import React from 'react';
import './OrderCard.css'
import MyButton from "../../UI/button/MyButton";
const OrderCard = ({img, name, description = '', action = '',quantity,price = '',onClick}) => {
    return (
        <div className='menu_item_Card' >
            <img src={img} className='menuItemIMG' />
            <h6>{name}</h6>
            <div>{description}</div>
            <div> кол-во {quantity}</div>
            <div>ИТОГО {price} ₽</div>
            {action && <MyButton children={action}  onClick={onClick}></MyButton>}
        </div>
    );
};

export default OrderCard;