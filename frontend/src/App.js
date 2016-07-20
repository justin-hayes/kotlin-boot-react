import React, { Component } from 'react';
import axios from 'axios';

export default class App extends Component {
    constructor(props) {
        super(props);
        this.state = {message: ''}
    }
    componentDidMount() {
        axios.get('/api/hello')
            .then((response) => {
                console.log(response);
                this.setState({
                    message: response.data
                });
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    render() {
        return (
            <h1>{this.state.message}</h1>
        );
    }
}