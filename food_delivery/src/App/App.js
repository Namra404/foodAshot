import '../Styles/App.css';
import UpBar from "../Components/UpBar/UpBar";
import MiddleContainer from "../Components/MiddleContainer/MiddleContainer";
import {Route, Router, Routes} from "react-router-dom";
import Login from "../Components/Pages/LoginPage/Login/Login";
import LayoutWithUpBar from "../Hoc/LayoutWithUpBar";
import Registration from "../Components/Pages/LoginPage/Registration/Registration";
import ChoosenRestaurant from "../Components/Pages/RestaurantPage/components/choosenRestaurants/ChoosenRestaurant";
import {useEffect, useState} from "react";
import ProtectRouter from "../Hoc/ProtectRouter";
import ProfilePage from "../Components/Pages/LoginPage/ProfilePage/ProfilePage";
import OrderPage from "../Components/Pages/OrderPage/OrderPage";
import AdminPage from "../Components/Pages/AdminPage/Admin/AdminPage";

function App() {
    const [isAuth,setAuth] = useState(false);
    const [searchText, setSearchText] = useState('');

    useEffect(() =>{

        const localStorageInfo = localStorage.getItem("userInfo");
        if(localStorageInfo && !isAuth){
            const userInfo = JSON.parse(localStorageInfo)
             console.log(userInfo)
            setAuth(true)

        }
    },[isAuth])
    console.log(isAuth)
    return (
        <div className="App">
            <Routes>
                <Route path={"/"} element={
                    <LayoutWithUpBar isAuth={isAuth} setAuth={setAuth}>
                        <MiddleContainer/>
                    </LayoutWithUpBar>
                }/>
                <Route path='/login' element={<Login setAuth={setAuth} />}/>
                <Route path='/registration' element={<Registration/>}/>
                <Route path='/restaurant/:id' element={<ChoosenRestaurant/> }/>
                <Route path='/profile' element={<ProfilePage/>} />
                <Route path='/order' element={<OrderPage/>}/>
                <Route path='/admin'element={<AdminPage/>}/>
            </Routes>



        </div>
    );
}

export default App;
