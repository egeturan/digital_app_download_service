import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import logo from './assets/images/ada-lovelace.jpg';
import profile from './assets/images/profile.png';
import Image from 'react-bootstrap/Image';
import axios from 'axios';

import {
  withRouter
} from "react-router-dom";

class NavigationAda extends React.Component {
  

  state = {
      authentication: 1,
      showDisplay: 0,
      keyWord: ""
  };
  
     //Button Message pass
     displaySwitch(number) {
      this.setState({
          showDisplay: number
      });
    }
    
    handleChange = event => {
      this.setState({ [event.target.name]: event.target.value });
    };

    searchApp(num) {
      console.log("KeyWord is: " + this.state.keyWord);

      const app = {
        text: this.state.keyWord
      }

      axios.post(`http://localhost:8080/search_app/`, app )
      .then(res => {
        let apps = [];
        apps = res.data;
        console.log(apps);
      })

    }
  


    render() {

      const { keyWord } = this.state;

      const style1 = {
          width: '80px',
          height: '80px',
      };

      const style2 = {
        width: '80px',
        height: '80px',
        marginLeft: '30px'
    };

      let displayer = null;




    let authenticatedNavbar = (
      <div>
      <Navbar bg="dark" variant="dark">
        <img src={logo} style={style1} className="App-logo" alt="logo"/>

      <Navbar.Brand href="#home" style={{marginLeft: "40px"}}> ADA STORE</Navbar.Brand>
      <Nav className="mr-auto">
        <Nav.Link href="#home" onClick={this.displaySwitch.bind(this, 6)}>Home</Nav.Link>
        <Nav.Link href="#features">Top Applications</Nav.Link>
      </Nav>

      <Form inline>
        <FormControl name="keyWord"  type="text" onChange={this.handleChange} value={keyWord} placeholder="keyWord" className="mr-sm-2" />
        <Button variant="success" onClick={this.searchApp.bind(this, 0)}>Search</Button>
      </Form>
      <Button variant="light" onClick={this.props.click} style={{width: "150px", height: "50px"}}>Logout</Button>
      <Image src={profile} style={style2} alt='alt' roundedCircle onClick={this.displaySwitch.bind(this, 5)}/>
    </Navbar>
    </div>
  );

    if(this.state.authentication == 0){
       
    }else if(this.state.authentication == 1){
      displayer = authenticatedNavbar;
    }

      
      return (
        <div>
          {displayer}
          </div>

      );
    }
  }

  export default withRouter(NavigationAda);