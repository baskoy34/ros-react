import React, { Component } from 'react';
import { connect } from 'react-redux'
import { Link } from 'react-router-dom'
import Badges from './Badges.js';
 class  Navbar extends Component {

     componentDidMount(){        
     }
     render(){
        return(
            <nav className="nav-wrapper">
                <div className="container">
                    <Link to="/" className="brand-logo">Shopping</Link>
                    
                    <ul className="right">
                        <li><Link to="/">Shop</Link></li>
                        <li><Link to="/cart">My cart</Link></li>
                        <li><Link to="/cart"><Badges value={this.props.totalItem}></Badges></Link></li>         
         <li>  Total Price {this.props.total}TL</li>
                    </ul>
                </div>
            </nav>
   
        
    )
     }

}
const mapStateToProps = (state)=>{
    return {
      totalItem: state.cart.itemCount,
      total:state.cart.totalPrice
    }
  }


export default connect(mapStateToProps)(Navbar);