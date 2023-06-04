import React, {useEffect, useState} from 'react';
import './RestaurantsCard.css'
import CardsItem from "../CardsItem/CardsItem";
import Cards from "../Cards/Cards";
import {v4 as uuidv4} from "uuid";
import {useNavigate} from "react-router-dom";
import login from "../../Pages/LoginPage/Login/Login";
import {observer} from "mobx-react-lite";
import RestaurantsMobX from "../../../Store/restaurantsMobX";

const RestaurantsCards = observer( ({categoriesID, onClick}) => {

    const navigate = useNavigate()

    function navigateToRestaurant(id, name) {
        navigate(`/restaurant/${id}`, {state: {name: name}})
    }

    useEffect(() => {
        fetch("http://localhost:8080/restaurants", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(categoriesID)
        }).then(res => res.json()).then((el) => {
            console.log(el)
            RestaurantsMobX.changeRestaurants(el)
        });
    }, [categoriesID]);

    function addViewToRestaurant(id) {
        fetch("http://localhost:8080/addViewToRestaurant", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({id: id})
        })
    }

    return (
        <div className='allRestaurants'>

            {RestaurantsMobX.filterRestaurants.map((restaurant) => (
                <div className='oneRestaurant'>
                    <CardsItem
                        key={restaurant.img}
                        img={restaurant.restaurant_img}
                        name={restaurant.name}
                        description={restaurant.description}
                        action={"перейти к ресторану"}
                        id={restaurant.id}
                        onClick={() => {
                            onClick()
                            navigateToRestaurant(restaurant.id, restaurant.name)
                            addViewToRestaurant(restaurant.id)
                        }}
                    />
                </div>
            ))}
        </div>
    );
});

export default RestaurantsCards;