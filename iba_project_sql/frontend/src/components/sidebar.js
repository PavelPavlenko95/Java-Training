import React, { Component } from 'react'
import {Link } from 'react-router-dom'


export default class sidebar extends Component {
    render() {
        return (
            <div>
                <ul className="nav">
                    <li className="nav-item">
                    <Link to="/" className="nav-link active">Home</Link>
                    </li>
                    <li className="nav-item">
                    <Link to="/api/user" className="nav-link active">Create User</Link>
                    </li>
                    <li className="nav-item">
                    <Link to="/api/event" className="nav-link active">Create Event</Link>
                    </li>
                </ul>
            </div>
        )
    }
}
