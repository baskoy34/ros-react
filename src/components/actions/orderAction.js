import axios from 'axios'
import { GET_ORDER,POST_ORDER,REMOVE_ORDER,UPDATE_ORDER} from './action-types/order-action'




export const post_Order=(response)=>{
    return{
        type:POST_ORDER,
        order:response
    }
}

export const fetchOrdersSucces=(response)=>{
    return{
        type:GET_ORDER,
        orders:response
    }
}




export const postOrder=(basket)=>{
    return dispatch=>{
        axios.post('http://localhost:8082/basket/Order',basket)
        .then(response=>{
            console.log(response.data)
            dispatch(post_Order(response.data))
        })
        .catch(e=>{
            console.log(e)
        })
    }
}

export const fetchOrders=(id)=>{
    return dispatch=>{
        axios.get('http://localhost:8082/basket/Order'+'?deskId='+id)
        .then(response=>{
            console.log(response.data)
            dispatch(fetchOrdersSucces(response.data))
        })
        .catch(e=>{
            console.log(e)
        })
    }
}
