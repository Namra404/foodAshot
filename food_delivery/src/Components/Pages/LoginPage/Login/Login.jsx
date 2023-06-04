import React, {useRef, useState} from 'react';
import "./Login.css"
import MyButton from "../../../UI/button/MyButton";
import {useNavigate} from "react-router-dom";
import LocalDiningIcon from "@mui/icons-material/LocalDining";
const Login = ({setAuth}) => {
    const navigate= useNavigate()
    function navigateToRegistrationPage(){
        navigate('/registration')
    }
    const[login, setLogin] = useState('');
    const[password, setPassword] = useState('');
    function loginUser(e){
        e.preventDefault()
        const data = {login,password}
        fetch('http://localhost:8080/api/auth',{
            method:'POST',
            body:JSON.stringify(data),
            headers: {'content-type':'application/json'}
        }).then((res) => res.json()).then(res => {
            localStorage.setItem('userInfo', JSON.stringify(res))
            setAuth(true)
            navigate('/')
        })
    }
    return (
        <div className='allElem'>
            <div className='UpBarIcon' style={{borderBottom: '1px solid #D2D0CC'}}>Еда <LocalDiningIcon/> Ашот</div>
            <form onSubmit={loginUser}>
                <input type="text" placeholder="Введите логин" name='login' onChange={(e) => {setLogin(e.target.value)}}/>
                <input type="password" placeholder="Введите пароль" name='password' onChange={(e) => {setPassword(e.target.value)}}/>
                <MyButton  type='submit' children="Войти"  />
            </form>


            <MyButton onClick={navigateToRegistrationPage} children="Зарегистрироваться" />
        </div>
    );
};

export default Login;