import {makeAutoObservable} from "mobx";

class RestaurantsMobX{

    restaurants = [];
    filterRestaurants = [];
    constructor() {
        makeAutoObservable(this)
    }

    changeRestaurants(restaurants){
        this.restaurants = restaurants
        this.filterRestaurants = restaurants.slice(0,6)
    }
    filtered(field){
        console.log(field)
        if(!field) {
            this.filterRestaurants = this.restaurants.slice(0,6)
            return
        }
        console.log("before",this.filterRestaurants)
        this.filterRestaurants = this.restaurants.filter((element)=> element.name.toLowerCase().includes(field.toLowerCase()) || element.description.toLowerCase().includes(field.toLowerCase()))
        console.log("after",this.filterRestaurants)
    }


}
export default new RestaurantsMobX()