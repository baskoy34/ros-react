import React from 'react';

export default function Orders(props){
    var   yourOrder=null;
    if(props.items!=null){
         yourOrder=  
    <li className="collection-item avatar" > 
         <div className="item-desc">
             <span className="title">SS</span>             
             <p><b>Sipariş Tutarı: {props.price}TL</b></p> 
             <p>
                 <b>Sipariş Durumu: {props.status}</b> 
             </p>
        </div>            
     </li>         
               
    }

    return (
    
            <ul className="collection">       
            {yourOrder}
            </ul>  
 
        
    )
}