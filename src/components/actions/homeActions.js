import axios from 'axios';
import { GET_ITEMS,ADD_TO_CART,GET_BASKET,SUB_QUANTITY,ADD_QUANTITY,ADD_SHIPPING} from './action-types/cart-actions'



export const getProduct = ( items ) => {    
    return {
        type: GET_ITEMS,
        items: items
    };
};
// export const getBasket = ( basket ) => {    
//     return {
//         type: GET_BASKET,
//         basket: basket
//     };
// };



export const getItems=()=>{
    return dispatch => {
        axios.get( 'http://localhost:8082/basket/item' )
            .then( response => {
                
               dispatch(getProduct(response.data));
            } )
            .catch( error => {
                
                //dispatch(fetchIngredientsFailed());
            } );
    };
}
// export const getBasketById=()=>{
//     return dispatch => {
//         axios.get( 'http://localhost:8082/basket/' )
//             .then( response => {
               
//                dispatch(getBasket(response.data));
//             } )
//             .catch( error => {
                
//                 //dispatch(fetchIngredientsFailed());
//             } );
//     };
// }



