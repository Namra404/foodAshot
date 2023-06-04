import React from 'react';
import {Navigate} from "react-router-dom";

const ProtectRouter = ({isAuth, children}) => {
    if(!isAuth) return <Navigate to={"/login"}/>
    return (
        children
    );
};

export default ProtectRouter;