import { updateObject } from '../utility';

import { GET_ITEMS,ADD_TO_CART, GET_BASKET} from '../actions/action-types/cart-actions'

const initState = {
    items: [ ],

    error:false
}
const getProduct=(state,action)=>{
    console.log(action.items)
    return updateObject( state, {
        items: action.items,        
    } ); 
}
// const getBasket=(state,action)=>{
//     return updateObject( state, {
//         itemcount:action.basket.basketProducts.length,
//         basketId:action.basket.basketId,
//         total:action.basket.totalPrice,
//     } ); 
// }

const addToCart=(state,action)=>{    
    let updatedState={        
        total:action.response.totalPrice,
        itemcount:action.response.itemCount
    }

    return updateObject(state,updatedState);
}

const reducer = ( state = initState,action ) => {    
    switch ( action.type ) {
        case GET_ITEMS : return getProduct( state, action );
        case ADD_TO_CART : return addToCart( state, action );       
        //case REMOVE_INGREDIENT: return removeIngredient(state, action);
        //case SET_INGREDIENTS: return setIngredients(state, action);    
        //case FETCH_INGREDIENTS_FAILED: return fetchIngredientsFailed(state, action);
        default: return state;
    }
};

export default reducer;