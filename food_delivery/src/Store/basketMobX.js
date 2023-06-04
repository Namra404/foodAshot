import {makeAutoObservable} from "mobx";
import basket from "../Components/Basket/Basket";

class BasketMobX {

    menuItems = []
    totalSum = 0;
    constructor() {
        makeAutoObservable(this)
    }



    clear(){
        this.menuItems = []
    }
    addToBasket(menuItem){
       const element = this.menuItems.find((item) => item.id === menuItem.id)
        if(element){
            element.quantity += 1
        }
        else{
            this.menuItems.push(menuItem)
        }
        this.totalSum += menuItem.quantity * menuItem.price
    }

    removeFromBasket(id){
        const element = this.menuItems.find((item) => item.id === id)
        this.menuItems = this.menuItems.filter(menuItem => menuItem.id !== id)
        this.totalSum -= element.quantity * element.price
    }
    clearRestaurant(){
        this.menuItems = []
        this.totalSum = 0;
    }
}
export default new BasketMobX()