import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css'
import { Provider } from 'react-redux';
import { createStore, applyMiddleware, compose, combineReducers } from 'redux';
import thunk from 'redux-thunk';
import homeReducer from './components/reducers/homeReducer';
import cartReducer from './components/reducers/cartReducer';

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const rootReducer = combineReducers({
    cart: cartReducer,
    home: homeReducer
});

const store = createStore(rootReducer, composeEnhancers(
    applyMiddleware(thunk)
));

ReactDOM.render(<Provider store={store}><App /></Provider>, document.getElementById('root'));

