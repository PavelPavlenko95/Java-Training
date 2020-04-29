import React, { Component } from 'react'
import axios from 'axios'

export default class form extends Component {

    state = {
        users: [],
        id: '',
        name: '',
        years: '',
        phone: '',
        email: ''
    }

    componentDidMount() {
        this.getUsers()
        console.log(this.state.users)
    }

    getUsers = async () => {
        const res = await axios.get('http://localhost:8080/api/user')
        this.setState({ users: res.data })
    }

    onChangeName = (e) => {
        this.setState({
            name: e.target.value
        })
    }

    onChangeYears = (e) => {
        this.setState({
            years: e.target.value
        })
    }

    onChangePhone = (e) => {
        this.setState({
            phone: e.target.value
        })
    }

    onChangeEmail = (e) => {
        this.setState({
            email: e.target.value
        })
    }

    onSubmit = async (e) => {
        e.preventDefault();
        const res = await axios.post('http://localhost:8080/api/user', {
            name: this.state.name,
            years: this.state.years,
            phone: this.state.phone,
            email: this.state.email
        });
        this.getUsers()
        this.setState({
            name: '',
            years: '',
            phone: '',
            email: ''
        })
        console.log(res)
    }

    deleteUser = async (id) => {
        await axios.delete(`http://localhost:8080/api/user/${id}`)
        this.getUsers()
    }

    render() {
        return (
            <div className="container p-5">
                <div className="row">
                    <div className="col">
                        <div>
                            <div className="card card-body">
                                <h3>Create New User</h3>
                                <form onSubmit={this.onSubmit}>
                                    <label htmlFor="staticEmail" className="col-form-label">Name</label>
                                    <div className="form-group">
                                        <input className="form-control" value={this.state.name} type="text" onChange={this.onChangeName} />
                                    </div>

                                    <label htmlFor="staticEmail" className="col-form-label">Years</label>
                                    <div className="form-group">
                                        <input className="form-control" value={this.state.years} type="text" onChange={this.onChangeYears} />
                                    </div>

                                    <label htmlFor="staticEmail" className="col-form-label">Phone</label>
                                    <div className="form-group">
                                        <input className="form-control" value={this.state.phone} type="text" onChange={this.onChangePhone} />
                                    </div>

                                    <label htmlFor="staticEmail" className="col-form-label">Email</label>
                                    <div className="form-group">
                                        <input className="form-control" value={this.state.email} type="text" onChange={this.onChangeEmail} />
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
                                    <th scope="col">Name</th>
                                    <th scope="col">Years</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Email</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.users.map(user => (
                                        <tr key={user.id} onDoubleClick={() => this.deleteUser(user.id)}>
                                            <td>{user.name}</td>
                                            <td>{user.years}</td>
                                            <td>{user.phone}</td>
                                            <td>{user.email}</td>
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
