import React, {useEffect, useState} from 'react';
import './ProfilePage.css'
import login from "../Login/Login";
import LocalDiningIcon from "@mui/icons-material/LocalDining";
import {useNavigate} from "react-router-dom";
import OrderCard from "../../../AllCards/orderCard/OrderCard";
import BasketCard from "../../../AllCards/BasketCard/BasketCard";
const ProfilePage = () => {
    const navigate= useNavigate()
    function navigateToMainPage(){
        navigate('/')
    }
    const [showBaskets, setShowBaskets] = useState(false);
    const handleButtonClick = () => {
        if (showBaskets){
            setShowBaskets(false);
        }else{
            setShowBaskets(true);
        }

    };
    const [Allbaskets, AllsetBaskets] = useState([]);
    useEffect(()=>{
        fetch("http://localhost:8080/api/getUserBasket/info", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({user_id: user.id})
        }).then(res => res.json()).then(AllsetBaskets)
    },[])
    const user = JSON.parse(localStorage.getItem("userInfo"))
    console.log("baskets",Allbaskets)
    return (
        <div>
            <div className='UpBarIcon' style={{borderBottom: '1px solid #D2D0CC', display:"flex", cursor:"pointer"}} onClick={navigateToMainPage}>Еда <LocalDiningIcon/> Ашот</div>
            <h2>User Information:</h2>
            <div>
                <p>Имя: {user.first_name}</p>
                <p>Фамилия: {user.last_name}</p>
                <p>Логин: {user.login}</p>
                <p>Адрес: {user.adress}</p>
                <p>Email: {user.email}</p>
                <p>Телефон: {user.phone}</p>
            </div>
            <button onClick={handleButtonClick}>мои заказы</button>
            {
                showBaskets &&  Allbaskets.map((basket) => (
                   <BasketCard
                       key={basket.id}
                       name={basket.name}
                       total_price={basket.total_price}
                       restaurant_id={basket.restaurant_id}
                       status={basket.status}
                       delivery_fee={basket.delivery_fee}
                       delivery_time={basket.delivery_time}
                       order_time={basket.order_time}
                       order={basket.order}
                   />
                ))
            }
        </div>
    );
};

export default ProfilePage;