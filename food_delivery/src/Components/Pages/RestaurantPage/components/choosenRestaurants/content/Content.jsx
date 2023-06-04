import React from 'react';
import './Content.css'
import CardsItem from "../../../../../AllCards/CardsItem/CardsItem";
import basketMobX from "../../../../../../Store/basketMobX";
import MenuItemCard from "../../../../../AllCards/MenuItemCard/MenuItemCard";
const Content = ({restaurantInfo,categoryID}) => {

    console.log(restaurantInfo)

    return (
        <div className='allContent'>
            <div className="retstaurantCard">
                <h2>{restaurantInfo?.name}</h2>
                <img src={restaurantInfo?.restaurant_img} style={{maxHeight:"400px"}}>{}</img>
            </div>

            <div className="menu_items">
                {
                  categoryID?  restaurantInfo?.menu_items?.filter((item) => item.menu_category_id === categoryID).map((item) => (
                        <MenuItemCard
                            key={item.id}
                            img={item.menu_items_img}
                            name={item.name}
                            description={item.description}
                            action={"купить"}
                            price={item.price}
                            onClick={() => basketMobX.addToBasket({...item, quantity: 1})}
                        />
                    )) : restaurantInfo?.menu_items?.map((item) => (
                      <MenuItemCard
                          key={item.id}
                          img={item.menu_items_img}
                          name={item.name}
                          description={item.description}
                          action={"купить"}
                          price={item.price}
                          onClick={() => basketMobX.addToBasket({...item, quantity: 1})}
                      />
                  ))
                }
            </div>
        </div>
    );
};

export default Content;