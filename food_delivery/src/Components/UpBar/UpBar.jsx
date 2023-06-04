import React from 'react';
import MyButton from "../UI/button/MyButton";
import SearchInput from "../UI/SearchInput/SearchInput";
import LocalDiningIcon from '@mui/icons-material/LocalDining';
import './UpBar.css'
import {useNavigate} from "react-router-dom";

const UpBar = ({isAuth, setAuth}) => {
    const navigate= useNavigate()
    function navigateToLoginPage(){
        navigate('/login')
    }
    function goToProfile(){
        navigate('/profile')
    }
    function handleClearLocalStorage() {
        localStorage.clear();
        setAuth(false);
    }

    return (
        <div className="UpBar">
            <div className='UpBarLogoInput'>
                <div className='UpBarIcon'>Еда <LocalDiningIcon/> Ашот</div>
                <SearchInput/>
            </div>

            {
                !isAuth ?  <MyButton onClick={navigateToLoginPage}>Войти</MyButton> :
                    <div className="profile-icon">
                        <img className="avatar" src={"https://cdn.icon-icons.com/icons2/1904/PNG/512/profile_121261.png"}/>
                        <div className="profile-menu">
                            <button onClick={goToProfile}>Профиль</button>
                            <button onClick={handleClearLocalStorage}>Выйти</button>
                        </div>
                    </div>

            }
        </div>
    );
};

export default UpBar;