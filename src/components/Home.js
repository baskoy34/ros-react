import React, { Component } from 'react';
import { connect } from 'react-redux'
import * as actions from '../components/actions/index';

 class Home extends Component{
    
    handleClick = (id,basketid,e)=>{
        e.preventDefault();
        this.props.addToCart(id,basketid); 
    }
    componentDidMount(){
        this.props.getItems();
        this.props.getBasket(1);
        console.log(this.props.items)
    }
    co
    render(){
 
        let itemList = this.props.items.map(item=>{
            return(
                <div className="card" key={item.id}>
                        <div className="card-image">
                            <img src={item.image}  alt={item.name}/>
                            <span className="card-title">{item.name}</span>
                            <span to="/" className="btn-floating halfway-fab waves-effect waves-light red" onClick={(e)=>{this.handleClick(item.id,1,e)}}><i className="material-icons">add</i></span>
                        </div>

                        <div className="card-content">
                            <p>{item.information}</p>
                            <p><b>Price: {item.price}$</b></p>
                        </div>
                 </div>

            )
        })

        return(
            <div className="container">
                <h3 className="center">Our items</h3>
                <div className="box">
                    {itemList}
                </div>       
            </div>
        )
    }
}
const mapStateToProps = (state)=>{
    return {
      items: state.home.items,
      totalItem: state.cart.itemCount,
      total:state.cart.totalPrice
    }
  }
const mapDispatchToProps= (dispatch)=>{
    
    return{
        addToCart: (id,basketid)=>dispatch(actions.addToCart(id,basketid)),
        getItems: () => dispatch(actions.getItems()),
        getBasket: ()=>dispatch(actions.getCartById()),
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Home)