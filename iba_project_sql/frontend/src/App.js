import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom'

import Sidebar from './components/sidebar'
import Form from './components/form'
import CreateEvent from './components/CreateEvent'

import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';

function App() {
    return (
        <Router>
            <Sidebar/>
            <Route path="/"/>
            <Route path="/api/user" component={Form}/>
            <Route path="/api/event" component={CreateEvent}/>
        </Router>
    );
}

export default App;
