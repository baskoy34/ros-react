import { updateObject } from '../utility';
import {REMOVE_ITEM,SUB_QUANTITY,ADD_QUANTITY,GET_BASKET,ADD_TO_CART } from '../actions/action-types/cart-actions'


const initState = {    
    addedItems:[],
    totalPrice: 0,
    itemCount:0,
    totalVat:0
}

const getBasket=(state,action)=>{
    console.log(action.item)
    return updateObject( state, {
        addedItems:action.item,
        totalPrice:action.totalPrice,
        totalVat:action.totalvat,
        itemCount:action.itemCount

    } ); 
}
const addQuantity=(state,action)=>{
    console.log(action.item)
    return updateObject( state, {
        addedItems:action.item,
        totalPrice:action.totalPrice,
        totalVat:action.totalvat,
        itemCount:action.itemCount

    } ); 
}
const removeItem=(state,action)=>{    
    return updateObject( state, {
        addedItems:action.item,
        totalPrice:action.totalPrice,
        totalVat:action.totalvat,
        itemCount:action.itemCount

    } ); 
}
const addToCart=(state,action)=>{    
    let updatedState={        
        totalPrice:action.response.totalPrice,
        itemCount:action.response.itemCount
    }

    return updateObject(state,updatedState);
}
const subtractQuantity=(state,action)=>{
    console.log(action.item)
    return updateObject( state, {
        addedItems:action.item,
        totalPrice:action.totalPrice,
        totalVat:action.totalvat,
        itemCount:action.itemCount

    } ); 
}


// const cartReducer= (state = initState,action)=>{   
//     //INSIDE HOME COMPONENT
//     if(action.type === ADD_TO_CART){
//           let addedItem = state.items.find(item=> item.id === action.id)
//           //check if the action id exists in the addedItems
//          let existed_item= state.addedItems.find(item=> action.id === item.id)
//          if(existed_item)
//          {
//             addedItem.quantity += 1 
//              return{
//                 ...state,
//                  total: state.total + addedItem.price 
//                   }
//         }
//          else{
//             addedItem.quantity = 1;
//             //calculating the total
//             let newTotal = state.total + addedItem.price 
            
//             return{
//                 ...state,
//                 addedItems: [...state.addedItems, addedItem],
//                 total : newTotal
//             }
            
//         }
//     }
//     if(action.type === REMOVE_ITEM){
//         let itemToRemove= state.addedItems.find(item=> action.id === item.id)
//         let new_items = state.addedItems.filter(item=> action.id !== item.id)
        
//         //calculating the total
//         let newTotal = state.total - (itemToRemove.price * itemToRemove.quantity )
//         console.log(itemToRemove)
//         return{
//             ...state,
//             addedItems: new_items,
//             total: newTotal
//         }
//     }
//     //INSIDE CART COMPONENT
//     if(action.type=== ADD_QUANTITY){
//         let addedItem = state.items.find(item=> item.id === action.id)
//           addedItem.quantity += 1 
//           let newTotal = state.total + addedItem.price
//           return{
//               ...state,
//               total: newTotal
//           }
//     }
//     if(action.type=== SUB_QUANTITY){  
//         let addedItem = state.items.find(item=> item.id === action.id) 
//         //if the qt == 0 then it should be removed
//         if(addedItem.quantity === 1){
//             let new_items = state.addedItems.filter(item=>item.id !== action.id)
//             let newTotal = state.total - addedItem.price
//             return{
//                 ...state,
//                 addedItems: new_items,
//                 total: newTotal
//             }
//         }
//         else {
//             addedItem.quantity -= 1
//             let newTotal = state.total - addedItem.price
//             return{
//                 ...state,
//                 total: newTotal
//             }
//         }
        
//     }

//     if(action.type=== ADD_SHIPPING){
//           return{
//               ...state,
//               total: state.total + 6
//           }
//     }

//     if(action.type=== 'SUB_SHIPPING'){
//         return{
//             ...state,
//             total: state.total - 6
//         }
//   }
    
//   else{
//     return state
//     }
    
// }
const reducer = ( state = initState,action ) => {    
    switch ( action.type ) {
        case GET_BASKET : return getBasket( state, action );
        case ADD_TO_CART : return addToCart( state, action ); 
        case ADD_QUANTITY: return addQuantity(state, action);
        case SUB_QUANTITY: return subtractQuantity(state, action);
        case REMOVE_ITEM: return removeItem(state, action);
        
        //case SET_INGREDIENTS: return setIngredients(state, action);    
        //case FETCH_INGREDIENTS_FAILED: return fetchIngredientsFailed(state, action);
        default: return state;
    }
};

export default reducer;
