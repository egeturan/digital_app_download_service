import React from 'react';
import AppRenderer from './AppRenderer';
import { Container, Grid, Divider, Rating } from 'semantic-ui-react';
import whatsapp from './assets/images/whatsapp.png';
import twitter from './assets/images/twitter.jpeg';
import tinder from './assets/images/tinder.png';
import netflix from './assets/images/Netflix.jpg';
import tiktok from './assets/images/tiktok.jpeg';
import AuthenticatedNavbar from './AuthenticatedNavbar';
import GLOBAL from './global';
import 'bootstrap/dist/css/bootstrap.min.css';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';




class HomePage2 extends React.Component {
  state = {
    showDisplay: 0,
    apps: [
      {appName: 'Twitter', image: twitter, rating: 5},
      {appName: 'Whatsapp', image: whatsapp, rating: 5},
      {appName: 'Tinder', image: tinder, rating: 3},
      {appName: 'Netflix', image: netflix, rating: 4},
      {appName: 'Tiktok', image: tiktok, rating: 1},
    ]
  };



  render(){

    return (
      
      <div style={{ backgroundColor: '#A1ADB7'}}>
        <div>
         
        </div>
        


        <div>
<Grid>

    <Grid.Column style={{}}>
    

    </Grid.Column>

    <Grid.Column style={{width: "auto", marginLeft: "260px"}}>

        <Container textAlign="left" style={{width: "1000px", height:"500px", backgroundColor:'white', marginTop:"10px", marginLeft:"50px"}}>
        <Row className="justify-content-md-center">
        <Col>
          <Card style={{ width: '10rem', backgroundColor:'#A1ADB7' }}>
              <Card.Img variant="top" src={this.state.apps[0].image} />
              <Card.Body style={{backgroundColor: 'white'}}>
                <Card.Title>{this.state.apps[0].appName}</Card.Title>
                <Rating maxRating={5} defaultRating={this.state.apps[0].rating} icon='star' size='small' disabled />
              </Card.Body>
          </Card>
        </Col>
        <Col >
          <Card style={{ width: '10rem', backgroundColor:'#A1ADB7' }}>
              <Card.Img variant="top" src={this.state.apps[1].image} />
              <Card.Body style={{backgroundColor: 'white'}}>
                <Card.Title>{this.state.apps[1].appName}</Card.Title>
                <Rating maxRating={5} defaultRating={this.state.apps[1].rating} icon='star' size='small' disabled />
              </Card.Body>
          </Card>
        </Col>
        <Col >
                <Card style={{ width: '10rem', backgroundColor:'#A1ADB7' }}>
                <Card.Img variant="top" src={this.state.apps[2].image} />
                <Card.Body style={{backgroundColor: 'white'}}>
                  <Card.Title>{this.state.apps[2].appName}</Card.Title>
                  <Rating maxRating={5} defaultRating={this.state.apps[2].rating} icon='star' size='small' disabled />
                </Card.Body>
            </Card>
        </Col>
        <Col>
          <Card style={{ width: '10rem', backgroundColor:'#A1ADB7' }}>
              <Card.Img variant="top" src={this.state.apps[3].image} />
              <Card.Body style={{backgroundColor: 'white'}} >
                <Card.Title>{this.state.apps[3].appName}</Card.Title>
                <Rating maxRating={5} defaultRating={this.state.apps[3].rating} icon='star' size='small' disabled />
              </Card.Body>
          </Card>
        </Col>
        <Col>
          <Card style={{ width: '10rem', backgroundColor:'#A1ADB7' }}>
              <Card.Img variant="top" src={this.state.apps[4].image} />
              <Card.Body style={{backgroundColor: 'white'}}>
                <Card.Title>{this.state.apps[4].appName}</Card.Title>
                <Rating maxRating={5} defaultRating={this.state.apps[4].rating} icon='star' size='small' disabled />
              </Card.Body>
          </Card>
        </Col>
        
        </Row>
        </Container>
        <div style={{width: "10px", height:"10px", backgroundColor:'#A1ADB7'}}></div>

        <Container textAlign="left" style={{width: "1300px", height:"300px", backgroundColor:'#A1ADB7', marginTop:"60px", marginLeft:"50px"}}>
        <Row className="justify-content-md-center">
        <Col>
          <Card style={{ width: '12rem', backgroundColor:'#A1ADB7' }}>
              <Card.Img variant="top" src={this.state.apps[0].image} />
              <Card.Body style={{backgroundColor: 'white'}}>
                <Card.Title>{this.state.apps[0].appName}</Card.Title>
                <Rating maxRating={5} defaultRating={this.state.apps[0].rating} icon='star' size='small' disabled />
              </Card.Body>
          </Card>
        </Col>
        <Col >
          <Card style={{ width: '12rem', backgroundColor:'#A1ADB7' }}>
              <Card.Img variant="top" src={this.state.apps[1].image} />
              <Card.Body style={{backgroundColor: 'white'}}>
                <Card.Title>{this.state.apps[1].appName}</Card.Title>
                <Rating maxRating={5} defaultRating={this.state.apps[1].rating} icon='star' size='small' disabled />
              </Card.Body>
          </Card>
        </Col>
        <Col >
                <Card style={{ width: '12rem', backgroundColor:'#A1ADB7' }}>
                <Card.Img variant="top" src={this.state.apps[2].image} />
                <Card.Body style={{backgroundColor: 'white'}}>
                  <Card.Title>{this.state.apps[2].appName}</Card.Title>
                  <Rating maxRating={5} defaultRating={this.state.apps[2].rating} icon='star' size='small' disabled />
                </Card.Body>
            </Card>
        </Col>
        <Col>
          <Card style={{ width: '12rem', backgroundColor:'#A1ADB7' }}>
              <Card.Img variant="top" src={this.state.apps[3].image} />
              <Card.Body style={{backgroundColor: 'white'}} >
                <Card.Title>{this.state.apps[3].appName}</Card.Title>
                <Rating maxRating={5} defaultRating={this.state.apps[3].rating} icon='star' size='small' disabled />
              </Card.Body>
          </Card>
        </Col>
        <Col>
          <Card style={{ width: '12rem', backgroundColor:'#A1ADB7' }}>
              <Card.Img variant="top" src={this.state.apps[4].image} />
              <Card.Body style={{backgroundColor: 'white'}}>
                <Card.Title>{this.state.apps[4].appName}</Card.Title>
                <Rating maxRating={5} defaultRating={this.state.apps[4].rating} icon='star' size='small' disabled />
              </Card.Body>
          </Card>
        </Col>
        </Row>
        </Container>

        </Grid.Column>

        </Grid>
      
        </div>
        

      </div>
    );
  
  };

}

export default HomePage2;