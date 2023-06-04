import React, {useEffect, useState} from 'react';
import './Basket.css'
import {useLocation, useNavigate, useParams} from "react-router-dom";
import CardsItem from "../AllCards/CardsItem/CardsItem";
import OrderCard from "../AllCards/orderCard/OrderCard";
import {observer} from "mobx-react-lite";
import basketMobX from '../../Store/basketMobX'
import MyButton from "../UI/button/MyButton";
import login from "../Pages/LoginPage/Login/Login";

const Basket = observer( () => {
     const [basketInRest, setbasketInRest] = useState([]);
    const [totalSum,setTotalSum] = useState(0);
    const {id} = useParams()
    const location = useLocation()
    const navigate= useNavigate()
    function navigateToOrderPage(){
        navigate('/order',{state:{id}})
    }
    useEffect(() => {
        const localInfo = localStorage.getItem("userInfo")
        if(localInfo){
            // const user = JSON.parse(localInfo);
            //     fetch("http://localhost:8080/api/getUserBasketInRestaurant/info", {
            //         method: 'POST',
            //         headers: {
            //             'Content-Type': 'application/json'
            //         },
            //         body: JSON.stringify({user_id: user.id, restaurant_id: id})
            //     }).then(res => res.json()).then(setbasketInRest).then(console.log(basketInRest)).then(() => {
            //
            //     });
        }
        else{
             navigate('/login')
        }
            return () => {
            // basketMobX.clear()
            }
        }, []);

    console.log(basketInRest)


    return (
        <div className='basketList'>
            <h2>КОРЗИНА</h2>

            <div className="basketElements">
                {
                    basketMobX.menuItems.map((element) => {
                        return (
                            <OrderCard
                                key={element.id}
                                img={element.menu_items_img}
                                name={element.name}
                                description={element.description}
                                price={element.price * element.quantity}
                                quantity={element.quantity}
                                action={"удалить из корзины"}
                                onClick ={() => {
                                    console.log(element.id);
                                    basketMobX.removeFromBasket(element.id)
                                }}
                            />
                        )
                    })
                }
            </div>

            <div className="total_sum">Итоговая сумма: {basketMobX.totalSum}</div>
            <MyButton onClick={navigateToOrderPage}>Оформить заказ</MyButton>
        </div>
    );
});

export default Basket;