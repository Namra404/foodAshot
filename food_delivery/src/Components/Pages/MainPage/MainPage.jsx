import React from 'react';
import './MainPage.css'
import UpBar from "../../UpBar/UpBar";
import MiddleContainer from "../../MiddleContainer/MiddleContainer";
const MainPage = () => {
    return (
        <div>
            <div className="DesktopHeader_header">
                <UpBar/>
            </div>
            <div  style={{margin:'0 auto',maxWidth:'1180px'}} >
                <MiddleContainer/>
            </div>
        </div>
    );
};

export default MainPage;