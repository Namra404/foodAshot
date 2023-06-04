import React from 'react';
import UpBar from "../Components/UpBar/UpBar";
import './LayoutWithUpBar.css'

const LayoutWithUpBar = ({isAuth,setAuth,children}) => {
    return (
        <React.Fragment>

            <div className="DesktopHeader_header">
                <UpBar isAuth={isAuth} setAuth={setAuth}/>
            </div>
            {
                children
            }

        </React.Fragment>
    );
};

export default LayoutWithUpBar;