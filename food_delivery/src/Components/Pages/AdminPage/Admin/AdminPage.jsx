import React, {useEffect} from 'react';
import "./AdminPage.css"
import {useNavigate} from "react-router-dom";
import {getTableSortLabelUtilityClass} from "@mui/material";
import LocalDiningIcon from "@mui/icons-material/LocalDining";
import MyButton from "../../../UI/button/MyButton";
import RestaurantsMobX from "../../../../Store/restaurantsMobX";
const AdminPage = () => {

    const navigate= useNavigate()
    useEffect(() => {
        const localInfo = localStorage.getItem("userInfo")
        if(localInfo != null){
            const user = JSON.parse(localInfo);
            if(!user.isAdmin){
                navigate('/')
            }
        }else navigate('/login')

    })

    function createRestaurant(e){
        e.preventDefault()
        const form = document.querySelector('.create_Restaurant_Form');
        const formData = new FormData(form)
        const data = {
            name: formData.get("restaurant_name"),
            description: formData.get("restaurant_description"),
            phone: formData.get("restaurant_phone"),
            address: formData.get("restaurant_address"),
            delivery_fee: +formData.get("restaurant_fee"),
            minimum_order_amount: +formData.get("restaurant_min_amount"),
            restaurant_img: formData.get("restaurant_img")
        }
        form.reset()
        fetch('http://localhost:8080/api/restaurant/create', {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {'content-type': 'application/json'}
        }).then(() => alert("ресторан создан"))
    }
    function changeRestaurantStatus(e){
        e.preventDefault()
        const form = document.querySelector('.changeRestaurantStatus');
        const formData = new FormData(form)
        const data = {
            id: formData.get("restaurant_id"),
            status: formData.get("restaurant_status")
        }
        form.reset()
        fetch('http://localhost:8080/api/restaurant/changeStatus', {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {'content-type': 'application/json'}
        }).then(() => alert("статус ресторана изменен"))

    }
    function getRestaurantByName(e){
        e.preventDefault()
        const form = document.querySelector('.searchRestaurantByName');
        const formData = new FormData(form)
        const data = {
            name: formData.get("restaurant_name")
        }
        form.reset()
        fetch('http://localhost:8080/api/restaurant/getRestaurantByName', {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {'content-type': 'application/json'}
        }).then((res) => res.text()).then((res) => alert(res))
    }
    function addMenuItem(e){
        e.preventDefault()
        const form = document.querySelector('.addMenuItem');
        const formData = new FormData(form)
        const data = {
            name: formData.get("menu_item_name"),
            description: formData.get("menu_item_description"),
            price: formData.get("menu_item_price"),
            menu_category_id: formData.get("menu_item_category"),
            restaurant_id:  formData.get("restaurant_id"),
            menu_items_img: formData.get("menu_item_img")
        }
        form.reset()
        fetch('http://localhost:8080/api/restaurant/addMenuItem', {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {'content-type': 'application/json'}
        }).then(() => alert("Блюдо создано"))
    }

    return (
        <div>
            <div className='UpBarIcon' style={{borderBottom: '1px solid #D2D0CC'}}>Еда <LocalDiningIcon/> Ашот ADMIN</div>
            <h3>Добавить ресторан:</h3>
            <form onSubmit={createRestaurant} className='create_Restaurant_Form'>
                <legend>Введите название ресторана</legend>
                <input name='restaurant_name' type="text" placeholder='введите имя'/>
                <legend>Введите описание ресторана</legend>
                <input name='restaurant_description' type="text" placeholder='введите описание'/>
                <legend>Введите телефон ресторана</legend>
                <input name='restaurant_phone' type="text" placeholder='введите телефон'/>
                <legend>Введите адрес ресторана</legend>
                <input name='restaurant_address' type="text" placeholder='введите адрес'/>
                <legend>Введите delivery_fee ресторана</legend>
                <input name='restaurant_fee' type="number" placeholder='введите fee'/>
                <legend>Введите минимальную сумму заказа ресторана</legend>
                <input name='restaurant_min_amount' type="number" placeholder='введите сумму'/>
                <legend>Введите ссылку на изображение ресторана</legend>
                <input name='restaurant_img' type="text" placeholder='введите ссылку'/>
                <MyButton type='submit' children='создать ресторан'/>
            </form>


            <h3>Изменение статуса ресторана (введите id ресторана и статус, который хотите присвоить: 1- активный, 0 -неактив)</h3>
            <form onSubmit={changeRestaurantStatus} className="changeRestaurantStatus">
                <legend>Введите id Ресторана</legend>
                <input name='restaurant_id' type='number' placeholder="restaurant id"/>
                <legend>Введите статус</legend>
                <input name="restaurant_status" type='number' placeholder="1 или 0"/>
                <MyButton type='submit' children='изменить статус'/>
            </form>

            {/*<h3>Удалить блюдо</h3>*/}
            {/*<form className="changeMenuItem">*/}
            {/*    <legend>Введите id блюда</legend>*/}
            {/*    <input name='restaurant_id' type='number' placeholder=""/>*/}
            {/*    <MyButton type='submit' children='подтвердить'/>*/}
            {/*</form>*/}

            <h3>узнать информацию о ресторане по названию</h3>
            <form onSubmit={getRestaurantByName} className='searchRestaurantByName'>
                <input name='restaurant_name'/>
                <MyButton type='submit' children='узнать'/>
            </form>


            <h3>добавить блюдо в ресторан</h3>
            <form onSubmit={addMenuItem} className="addMenuItem">
                <legend>Название блюда</legend>
                <input name='menu_item_name'/>
                <legend>Описание</legend>
                <input name='menu_item_description'/>
                <legend>Цена</legend>
                <input name='menu_item_price'/>
                <legend>id категории</legend>
                <input name='menu_item_category'/>
                <legend>id ресторана</legend>
                <input name='restaurant_id'/>
                <legend>ссылка на картинку</legend>
                <input name='menu_item_img'/>
                <MyButton type='submit' children='подтвердить'/>
            </form>
           <h1>По остальным вопросам и просьбам обращайтесь по телефону 8-800-555-35-35</h1>
            {/*<h3>Узнать блюдо по id ресторана и названию</h3>*/}

            {/*<form>*/}
            {/*    <legend>введите id ресторана</legend>*/}
            {/*    <input/>*/}
            {/*    <legend>введите название блюда</legend>*/}
            {/*    <input/>*/}
            {/*</form>*/}


        </div>
    );
};

export default AdminPage;