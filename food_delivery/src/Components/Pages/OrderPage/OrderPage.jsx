import React, {useEffect} from 'react';
import './OrderPage.css'

import OrderCard from "../../AllCards/orderCard/OrderCard";
import basketMobX from "../../../Store/basketMobX";
import login from "../LoginPage/Login/Login";
import {useLocation, useNavigate, useParams} from "react-router-dom";
import MenuItemCard from "../../AllCards/MenuItemCard/MenuItemCard";
import LocalDiningIcon from "@mui/icons-material/LocalDining";
const OrderPage = () => {

    const navigate= useNavigate()
    function navigateToMainPage(){
        navigate('/')
    }

    const user = JSON.parse(localStorage.getItem("userInfo"))

    const restId = useLocation()

    useEffect(()=>{
        if([...basketMobX.menuItems].map(element => ({...element})).length > 0) {
            const data =  {
                "data": {
                    "items": [...basketMobX.menuItems].map(element => ({...element})),
                    "user_id": user.id,
                    "restaurant_id": restId.state.id
                }
            }
            console.log(basketMobX.menuItems)

            fetch("http://localhost:8080/api/basket", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            })

        }
        },[])

    return (
        <div>
            <div className='UpBarIcon' style={{borderBottom: '1px solid #D2D0CC', display:"flex", cursor:"pointer"}} onClick={navigateToMainPage}>Еда <LocalDiningIcon/> Ашот</div>
            СПАСИБО ЗА ЗАКАЗ!
            {
                console.log([...basketMobX.menuItems].map(element => ({...element})))
            }
            {
                basketMobX.menuItems.map((element) => {
                    return (
                        <OrderCard
                            key={element.id}
                            img={element.menu_items_img}
                            name={element.name}
                            price={element.price * element.quantity}
                            quantity={element.quantity}
                        />
                    )
                })
            }
            <h3>ОБЩАЯ СУММА ВСЕГО ЗАКАЗА = {basketMobX.totalSum} ₽</h3>
        </div>
    );
};

export default OrderPage;