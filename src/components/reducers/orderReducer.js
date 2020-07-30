import { updateObject } from '../utility';
import { GET_ORDER,POST_ORDER,REMOVE_ORDER,UPDATE_ORDER} from '../actions/action-types/order-action'

const initialState={
    orders:[],
    loading: false
}


const postOrderSucces=(state,action)=>{
    
    return updateObject(state,{
        loading:false,
        orders:state.orders.concat(action.order)
    })
}

const fetchOrdersSuccess = ( state, action ) => {
    return updateObject( state, {
        orders: action.orders,
        loading: false
    } );
};



const reducer = ( state = initialState, action ) => {
    switch ( action.type ) {
        case GET_ORDER: return fetchOrdersSuccess( state, action );
        case POST_ORDER: return postOrderSucces( state, action );
        default: return state;
    }
};

export default reducer;