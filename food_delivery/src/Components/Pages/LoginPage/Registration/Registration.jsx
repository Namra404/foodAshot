import React from 'react';
import "./Registration.css"
import {useNavigate} from "react-router-dom";
import MyButton from "../../../UI/button/MyButton";
import LocalDiningIcon from "@mui/icons-material/LocalDining";

const Registration = () => {
    const navigate = useNavigate()

    function navigateToLoginPage() {
        navigate('/login')
    }

    function registerUser(e) {
        e.preventDefault()
        const form = document.querySelector('form');
        const formData = new FormData(form)
        const data = {
            first_name: formData.get('first_name'),
            last_name: formData.get('last_name'),
            login: formData.get('login'),
            password: formData.get('password'),
            phone: formData.get('phone'),
            adress: formData.get('adress'),
            email: formData.get('email')
        }
        fetch('http://localhost:8080/api/registration', {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {'content-type': 'application/json'}
        }).then((res) => res.text()).then(res => {
            navigate('/login')
        }).catch(error => {
            console.error(error)
        })
    }

    return (
        <div >

            <form onSubmit={registerUser} className='registrationForm'>
                <div className='UpBarIcon' style={{borderBottom: '1px solid #D2D0CC'}}>Еда <LocalDiningIcon/> Ашот</div>
                <legend>Имя</legend>
                <input name='first_name' type="text" placeholder='введите имя'/>
                <legend>Фамилия</legend>
                <input name='last_name' type="text" placeholder='введите фамилию'/>
                <legend>Логие</legend>
                <input name='login' type="text" placeholder='введите логин'/>
                <legend>Пароль</legend>
                <input name='password' type="password" placeholder='введите пароль'/>
                <input name='asseptPass' type="password" placeholder='подтвердите пароль'/>
                <legend>Номер телефона</legend>
                <input name='phone' type="tel" placeholder='введите телефон'/>
                <legend>Адрес</legend>
                <input name='adress' type="text" placeholder='введите адресс'/>
                <legend>E-mail</legend>
                <input name='email' type="email" placeholder='введите email'/>
                <MyButton type='submit' children='зарегестрироваться'/>
            </form>


        </div>
    );
};

export default Registration;