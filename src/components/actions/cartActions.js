import axios from 'axios'
import { REMOVE_ITEM,SUB_QUANTITY,ADD_QUANTITY,GET_BASKET,ADD_TO_CART} from './action-types/cart-actions'



export const getCart= (response)=>{
    
    return{
        type: GET_BASKET,
        item:response.basketProducts,
        totalPrice:response.totalPrice,
        totalVat:response.totalVat,
        itemCount:response.totalItem
    }
}
export const addItem= (response)=>{
    return{
        type: ADD_TO_CART,
        response:response
    }
}

// export const removeItem=(id)=>{
//     return{
//         type: REMOVE_ITEM,
//         id
//     }
// }

// export const subtractQuantity=(id)=>{
//     return{
//         type: SUB_QUANTITY,
//         id
//     }
// }


export const addQuantity=(response)=>{
    return{
        type: ADD_QUANTITY,
        item:response.basketProducts,
        totalPrice:response.totalPrice,
        totalVat:response.totalVat,
        itemCount:response.totalItem
    }
}
export const removeBasketItem=(response)=>{
    return{
        type: REMOVE_ITEM,
        item:response.basketProducts,
        totalPrice:response.totalPrice,
        totalVat:response.totalVat,
        itemCount:response.totalItem
    }
}

export const subtractQuantity=(response)=>{
    return{
        type: SUB_QUANTITY,
        item:response.basketProducts,
        totalPrice:response.totalPrice,
        totalVat:response.totalVat,
        itemCount:response.totalItem
    }
}
export const increaseQuantity=(basketid,productid)=>{
    var obj={
        basketid:basketid,
        productid:productid,
        proceses:"increase"       
     };
    return dispatch=>{
        axios.post('http://localhost:8082/basket/updateQuentityItem',obj)
        .then(response=>{
            console.log(response.data)
            dispatch(addQuantity(response.data))
        })
        .catch(e=>{
            console.log(e)
        })
    }
}

export const decreaseQuantity=(basketid,productid)=>{
   
        var obj={
            basketid:basketid,
            productid:productid,
            proceses:"decrease"       
         };
        return dispatch=>{
            axios.post('http://localhost:8082/basket/updateQuentityItem',obj)
            .then(response=>{
                console.log(response.data)
                dispatch(subtractQuantity(response.data))
            })
            .catch(e=>{
                console.log(e)
            })
        }
    }
    export const removeItem=(basketid,productid)=>{
   
        var obj={
            basketid:basketid,
            productid:productid               
         };
        return dispatch=>{
            axios.post('http://localhost:8082/basket/removeItem',obj)
            .then(response=>{
                console.log(response.data)
                dispatch(removeBasketItem(response.data))
            })
            .catch(e=>{
                console.log(e)
            })
        }
    }

    

export const getCartById=(basketId)=>{    

    return dispatch => {
        axios.get( 'http://localhost:8082/basket')
            .then( response => {
                console.log(response.data)
               dispatch(getCart(response.data));
            })
            .catch( error => {
                console.log(error)                
            });
    };
}


export const addToCart=(id,basketId)=>{    
    var obj={
        productDto:{
            id:id
        },         
         basketId:basketId,
         piece:1
     };
     return dispatch => {
         axios.post( 'http://localhost:8082/basket',obj )
             .then( response => {                
                dispatch(addItem(response.data));
             })
             .catch( error => {
                 console.log(error)
                 //dispatch(fetchIngredientsFailed());
             });
     };
 }
