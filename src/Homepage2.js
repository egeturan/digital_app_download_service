import React from 'react';
import AppRenderer from './AppRenderer';
import { Container, Grid, Divider, Rating } from 'semantic-ui-react';
import whatsapp from './assets/images/whatsapp.png';
import twitter from './assets/images/twitter.jpeg';
import tinder from './assets/images/tinder.png';
import netflix from './assets/images/Netflix.jpg';
import tiktok from './assets/images/tiktok.jpeg';
import 'bootstrap/dist/css/bootstrap.min.css';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import ApplicationInformationPage from './ApplicationInformationPage';
import { Header, Icon, Image, Menu, Segment, Sidebar } from 'semantic-ui-react'
import {
  withRouter
} from "react-router-dom";
import ProfilePage from './ProfilePage';
import axios from 'axios';


class HomePage2 extends React.Component {
  state = {
    appsTaken: [],
    appShow: 0,
    showDisplay: 0,
    apps: [
      {appName: 'Twitter', image: twitter, rating: 5},
      {appName: 'Whatsapp', image: whatsapp, rating: 5},
      {appName: 'Tinder', image: tinder, rating: 3},
      {appName: 'Netflix', image: netflix, rating: 4},
      {appName: 'Tiktok', image: tiktok, rating: 1},
    ],
    visible: true
  };



  displaySwitch(number) {
    this.setState({
        showDisplay: number
    });
  }


  
  setVisible(number) {
    if(this.state.visible == true){
    this.setState({
        visible: number
    });
  }
  }


    
  getAppsOnSale(number) {
    console.log("enters1");
    axios.get(`http://localhost:8080/get_app_on_sale`)
      .then(res => {
        let newEditorIds = {appsTaken: res.data};
        console.log(newEditorIds);
        this.setState(newEditorIds);
      })


      this.setState({
        appShow: 1
    });

  }

  getAppDownloadViews(number) {
    console.log("enters2");
    axios.get(`http://localhost:8080/get_app_download_views`)
    .then(res => {
      let apps = []
      apps = res.data;
      console.log(apps);
    })
  }

  getAppRateViews(number) {
    console.log("enters3");
    axios.get(`http://localhost:8080/get_app_rate_views`)
    .then(res => {

      let newEditorIds = {appsTaken: res.data};
        console.log(newEditorIds);
        this.setState(newEditorIds);
    })
  }

  GetAppDownloadRateViews(number) {
    console.log("enters4");
    axios.get(`http://localhost:8080/get_app_download_rate_views`)
    .then(res => {
      let newEditorIds = {appsTaken: res.data};
      console.log(newEditorIds);
      this.setState(newEditorIds);
    })
  }

  GetAppPriceRange(number) {

  }


  render(){

    let displayer = null;

    let appView = null;

    if(this.state.appsShow == 1){
      appView = (
        <div>
        { 
          this.state.appsTaken.map(person => <li>{ <h1>Ege</h1>}</li>
        )}
        </div>
  
      );
    }

    if(this.state.showDisplay == 0){
      displayer =     ( <div style={{ backgroundColor: '#A1ADB7'}}>

        {console.log(this.state.appsTaken)}
<Grid>

  <Grid.Column style={{overflowX : 'auto', fontSize: '20px', left: "0px", position: "fixed", alignSelf: "flex-end", width:"200px", height:"560px", top:"100px"}}>

  <Sidebar.Pushable as={Segment}>
      <Sidebar
        as={Menu}
        animation='overlay'
        icon='labeled'
        inverted
        vertical
        visible={"visible"}
        width='200px'
      >
        <Menu.Item as='a' onClick={this.getAppsOnSale.bind(this, 11)}>
          <Icon name='app store' />
          Get app on sale
        </Menu.Item>
        <Menu.Item as='a' onClick={this.getAppDownloadViews.bind(this, 12)}>
          <Icon name='app store' />
          Get App Download View
        </Menu.Item>
        <Menu.Item as='a' onClick={this.getAppRateViews.bind(this, 13)}>
          <Icon name='app store' />
          Get App Rate View
        </Menu.Item>
        <Menu.Item as='a' onClick={this.GetAppDownloadRateViews.bind(this, 14)}>
          <Icon name='app store' />
          Get App Rate Download View
        </Menu.Item>
        <Menu.Item as='a' onClick={this.GetAppPriceRange.bind(this, 14)}>
          <Icon name='app store' />
          Get App Price Range
        </Menu.Item>
        <Menu.Item as='a' onClick={this.displaySwitch.bind(this, 10)}>
          <Icon name='user' />
          Profile
        </Menu.Item>
        <Menu.Item as='a'>
          <Icon name='setting' />
          Settings
        </Menu.Item>
      </Sidebar>

      <Sidebar.Pusher>
        <Segment basic >
      
        </Segment>
      </Sidebar.Pusher>
    </Sidebar.Pushable>

  </Grid.Column>

  <Grid.Column style={{width: "auto", marginLeft: "260px"}}>

      <Container textAlign="left" style={{width: "1000px", height:"500px", backgroundColor:'#A1ADB7', marginTop:"10px", marginLeft:"50px"}}>
      <Row style={{width: "1000px", height:"auto"}}>
      { 

          this.state.appsTaken.map(person =>  <Card onClick={this.displaySwitch.bind(this, 1)} style={{ width: '10rem', backgroundColor:'#A1ADB7' }}>
          <Card.Img variant="top" src={this.state.apps[1].image} />
          <Card.Body style={{backgroundColor: 'white'}}>
            <Card.Title>{person.app_name}</Card.Title>
            {"App Name: " + person.app_name} {"Price: " + person.price} {"Text: " + person.text}
            <Rating maxRating={5} defaultRating={this.state.apps[0].rating} icon='star' size='small' disabled />
          </Card.Body>
      </Card>
   
        )}
            </Row>
   
      </Container>

      </Grid.Column>

      </Grid>
    
      </div>
      



      );

    }else if(this.state.showDisplay == 1){
        displayer = <ApplicationInformationPage appP = {this.state.apps[this.state.showDisplay - 1]}></ApplicationInformationPage>
    }else if(this.state.showDisplay == 2){
        displayer = <ApplicationInformationPage></ApplicationInformationPage>
    }
    else if(this.state.showDisplay == 10){
      displayer = <ProfilePage></ProfilePage>
  }

    return (
      <div>
      {displayer}
      </div>
 
    );
  
  };

}

export default withRouter(HomePage2);