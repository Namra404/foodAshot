import React from 'react';
import './BasketCard.css'
import OrderCard from "../orderCard/OrderCard";
const BasketCard = ({total_price, status, delivery_fee,delivery_time,restaurant_id,order,name,order_time}) => {
    console.log(restaurant_id)
    return (
        <div>
            <h2> заказ в {name}</h2>
            <div>Заказ совершен {order_time}</div>
            <div>итоговая стоимость всего заказа: {total_price}</div>
            <div>стоимость доставки {delivery_fee}</div>
            <div>статус: {status === 1 ? 'Доставлено' : 'Доставляется'}</div>
            <div>время достаки {delivery_time}</div>
            <b>Элементы заказа</b>
            {order.map((element) => (
                <OrderCard
                    img={element.menuItemsEntity.menu_items_img}
                    name={element.name}
                    description={element.description}
                    price={element.price * element.quantity}
                    quantity={element.quantity}
                />
            ))}
        </div>
    );
};

export default BasketCard;