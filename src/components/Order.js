import React , { Component }from 'react';
import { connect } from 'react-redux';
import MyOrders from './MyOrders';
import * as actions from '../components/actions/index';


class Order extends Component {
    componentDidMount(){
        this.props.onFetchOrders(1);
    }
    render() {
        let orders = null;
        if ( this.props.orders!=null ) {
            orders = this.props.orders.map( order => (
                <MyOrders
                    key={order.id}
                    items={order.basket.basketProducts}
                    price={order.basket.totalPrice}
                    status={order.orderstatus} />
            ))
        }
        return (
            <div className="container">
                <div className="cart">                    
                     {orders}                
                    </div>
                </div>
        );
    }
  }
  
  const mapStateToProps = state => {
    return {
        orders: state.order.orders,
        loading: state.order.loading
    };
};

const mapDispatchToProps = dispatch => {
    return {
        onFetchOrders: (id) => dispatch( actions.fetchOrders(id) )
    };
};

export default connect( mapStateToProps, mapDispatchToProps ) (Order) ;