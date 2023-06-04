import React from 'react';
import './Cards.css'
import CardsItem from "../CardsItem/CardsItem";

const Cards = (props) => {
    return (
        <div className='Cards'>
          <CardsItem props = {props} />
        </div>
    );
};

export default Cards;