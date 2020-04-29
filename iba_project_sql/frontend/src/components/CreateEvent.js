import React, { Component } from 'react'
import axios from 'axios'

export default class CreateEvent extends Component {

    state = {
        events: [],
        id: '',
        valores: {}
    }

    componentDidMount() {
        this.getEvents()
        console.log(this.state.events)
    }

    getEvents = async () => {
        const res = await axios.get('http://localhost:8080/api/event')
        this.setState({ events: res.data })
    }     

     onChangeInput = (e) => {
        const content = e.target
        const author = e.target
        const date = e.target

        this.setState({ content, author, date })
    }

    onChangeInput = (e) => {
        this.setState({
            valores: {
                ...this.state.valores,
                [e.target.name]: e.target.value
            }
        })
    }

    onSubmit = async (e) => {
        e.preventDefault();
        const res = await axios.post('http://localhost:8080/api/event', {
           valores: this.state.valores
        });
        this.getEvents()
        this.setState({
            valores: ''
        })
        console.log(res)
    }

    deleteEvent = async (id) => {
        await axios.delete(`http://localhost:8080/api/event/${id}`)
        this.getEvents()
    }

    render() {
        return (
            <div className="container p-5">
                <div className="row">
                    <div className="col">
                        <div>
                            <div className="card card-body">
                                <h3>Create New Event</h3>
                                <form onSubmit={this.onSubmit}>
                                    <label htmlFor="staticEmail" className="col-form-label">Content</label>
                                    <div className="form-group">
                                        <input className="form-control" name='content' type="text" onChange={this.onChangeInput} />
                                    </div>

                                    <label htmlFor="staticEmail" className="col-form-label">Author</label>
                                    <div className="form-group">
                                        <input className="form-control" name='author' type="text" onChange={this.onChangeInput} />
                                    </div>

                                    <label htmlFor="staticEmail" className="col-form-label">Date</label>
                                    <div className="form-group">
                                        <input className="form-control" name='date' type="text" onChange={this.onChangeInput} />
                                    </div>

                                    <div className="container p-2">
                                        <button type="submit" className="btn btn-primary">Add</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div className="col">
                        <table className="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Content</th>
                                    <th scope="col">Author</th>
                                    <th scope="col">Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.events.map(event => (
                                        <tr key={event.id} onDoubleClick={() => this.deleteEvent(event.id)}>
                                            <td>{event.content}</td>
                                            <td>{event.author}</td>
                                            <td>{event.date}</td>
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        )
    }
}
