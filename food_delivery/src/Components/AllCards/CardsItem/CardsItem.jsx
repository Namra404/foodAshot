import React from 'react';
import './CardsItem.css'
import MyButton from "../../UI/button/MyButton";
import {v4 as uuidv4} from 'uuid'
import {useNavigate} from "react-router-dom";

const CardsItem = ({img, name, description, action = '', onClick}) => {
    const navigate= useNavigate()
    // function navigateToRestaurant(){
    //     navigate(`/restaurant/${id}`,{state:{name: name}})
    // }

    return (
        <div className='card' >
            <img src={img} className={'cardImg'} />
            <h6>{name}</h6>
            <div className="cardText">{description}</div>
            {action && <MyButton children={action} onClick={onClick} ></MyButton>}
        </div>
    );
};

export default CardsItem;