import axios from 'axios'
import { GET_BASKET,ADD_TO_CART} from './action-types/cart-actions'



export const getCart= (response)=>{
    
    return{
        type: GET_BASKET,
        item:response.basketProducts,
        totalPrice:response.totalPrice,
        totalVat:response.totalVat,
        itemCount:response.totalItem
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


// export const addQuantity=(id)=>{
//     return{
//         type: ADD_QUANTITY,
//         id
//     }
// }

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
export const addItem= (response)=>{
    return{
        type: ADD_TO_CART,
        response:response
    }
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
