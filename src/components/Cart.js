import React, { Component } from 'react';
import { connect } from 'react-redux'
import { Link } from 'react-router-dom'
//import { removeItem,addQuantity,subtractQuantity} from './actions/cartActions'
import Recipe from './Recipe'
import * as actions from '../components/actions/index';
class Cart extends Component{

    componentDidMount(){
        this.props.getBasket(1)
    }
    //to remove the item completely
    handleRemove = (basketid,productid)=>{
        this.props.removeItem(basketid,productid);
    }
    //to add the quantity
    handleAddQuantity = (basketid,productid)=>{
        this.props.addQuantity(basketid,productid);
    }
    //to substruct from the quantity
    handleSubtractQuantity = (basketid,productid)=>{
        this.props.subtractQuantity(basketid,productid);
    }
    postOrder=()=>{
        const errand={
            basket:{
                id:1,
                basketProducts:this.props.items,
                totalPrice:this.props.total,
                totalItem:this.props.itemCount,
                totalVat:this.props.totalVat
            },
            active:false,
            orderstatus:"OPEN",
            paymentstatus:false
        }
        this.props.postOrder(errand)

    }
    render(){
              
        let addedItems = this.props.items.length ?
            (  
                this.props.items.map(item=>{
                    return(                       
                        <li className="collection-item avatar" key={item.id}>
                                    <div className="item-img"> 
                                        <img src={item.product.image} alt={item.img} className=""/>
                                    </div>
                                
                                    <div className="item-desc">
                                        <span className="title">{item.product.name}</span>
                                        <p>{item.product.information}</p>
                                        <p><b>Price: {item.product.price}$</b></p> 
                                        <p>
                                            <b>Quantity: {item.piece}</b> 
                                        </p>
                                        <div className="add-remove">
                                            <Link to="/cart"><i className="material-icons" onClick={()=>{this.handleAddQuantity(1,item.product.id)}}>arrow_drop_up</i></Link>
                                            <Link to="/cart"><i className="material-icons" onClick={()=>{this.handleSubtractQuantity(1,item.product.id)}}>arrow_drop_down</i></Link>
                                        </div>
                                        <button className="waves-effect waves-light btn pink remove" onClick={()=>{this.handleRemove(1,item.product.id)}}>Remove</button>
                                    </div>
                                    
                                </li>
                         
                    )
                })
            ):

             (
                <p>Nothing.</p>
             )
       return(
            <div className="container">
                <div className="cart">
                    <h5>You have ordered:</h5>
                    <ul className="collection">
                        {addedItems}
                    </ul>
                </div> 
                <Recipe postOrder={this.postOrder}/>          
            </div>
       )
    }
}


const mapStateToProps = (state)=>{
    return{
        items: state.cart.addedItems,
        total:state.cart.totalPrice,
        itemCount:state.cart.itemCount,
        totalVat:state.cart.totalVat    
    }
}
const mapDispatchToProps = (dispatch)=>{
    return{
        getBasket: (id)=>{dispatch(actions.getCartById(id))},  
        addQuantity :(basketid,productid)=>{dispatch(actions.increaseQuantity(basketid,productid))} ,
        subtractQuantity :(basketid,productid)=>{dispatch(actions.decreaseQuantity(basketid,productid))} ,   
        removeItem :(basketid,productid)=>{dispatch(actions.removeItem(basketid,productid))} , 
        postOrder :(order)=>{dispatch(actions.postOrder(order))}       
    }
}
export default connect(mapStateToProps,mapDispatchToProps)(Cart)