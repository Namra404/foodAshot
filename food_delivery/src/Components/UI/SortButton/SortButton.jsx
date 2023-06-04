import React from 'react';
import './SortButton.css'
import TuneIcon from '@mui/icons-material/Tune';
import HighlightOffIcon from '@mui/icons-material/HighlightOff';
const SortButton = ({setCategoriesID}) => {
    function clearCategory() {
        setCategoriesID([]);
    }

    return (
        <div style={{display:'flex', alignItems:'center', gap:'5px'}}>
            <HighlightOffIcon style={{cursor:'pointer'}} onClick={clearCategory} />
            Очистить
        </div>
    );

};

export default SortButton;