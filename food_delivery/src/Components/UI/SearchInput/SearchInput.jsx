import React, {useState} from 'react';
import MyButton from "../button/MyButton";
import './SearchInput.css'
import SearchIcon from '@mui/icons-material/Search';
import {observer} from "mobx-react-lite";
import RestaurantsMobX from "../../../Store/restaurantsMobX";

const SearchInput = observer (() => {
    const [searchText, setSearchText] = useState('');

    const handleSearch = (e) =>{
        setSearchText(e.target.value)
        RestaurantsMobX.filtered(e.target.value)
    }

    return (
        <div className="SearchInput">
            <div className='SearchIcon'>
                <SearchIcon/>
                <input className='Inpt' placeholder="Найти ресторан" type="text" value={searchText}
                       onChange={handleSearch} />
            </div>
            <div>
                <button className = 'InputButton'>Найти</button>
            </div>
        </div>
    );
});

export default SearchInput;