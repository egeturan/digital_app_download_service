import React from 'react';
import { Grid, Container, Divider, Statistic, Form, Button, Icon, Rating, GridColumn} from 'semantic-ui-react';
import whatsapp from './assets/images/whatsapp.png';
import ButtonSemantic from './ButtonSemantic.js';
import ListGroup from 'react-bootstrap/ListGroup';
import Image from 'react-bootstrap/Image';
import AppComments from './AppComments';
import Carousel from 'react-bootstrap/Carousel';
import Tab from 'react-bootstrap/Tab';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import w1 from './assets/images/screenW1.png';
import w2 from './assets/images/screenW2.png';
import twitter from './assets/images/twitter.jpeg';
import ins from './assets/images/ins.jpeg';
import tiktok from './assets/images/tiktok.jpeg';
import AxiosTest from './AxiosTest';
import GLOBAL from './global';


class ApplicationInformationPage extends React.Component{

    state= {
        showDisplay: 0,
        authenticate: 0,
        user: null
    };

    componentDidMount(){
        if(GLOBAL.userG == null){
            this.setState({
                authenticate: 0
            });
        }else{
            console.log("User name is: " + GLOBAL.userG.username);
            this.setState({
                authenticate: 1,
                user: GLOBAL.userG
            });
        }
      }

    displayer(number) {
        this.setState({
          showDisplay: number
        });
      }
    
    render(){


        let cont = (
            <Container style={{marginTop: "40px"}}>
           
            <Grid>
                <GridColumn>
                <Image  src={whatsapp} style={{width: "50px", height: "50px"}} alt='alt' roundedCircle />
                </GridColumn>
                <GridColumn style={{marginLeft: "40px"}}>
                    <h4>WhatsApp</h4>
                 
                    
                    </GridColumn>
            </Grid>

            <h4>Messagin App</h4>

       
            <Divider/>
        </Container>

        );


        let approveRequest = (
            <div style={{width: "auto", height:"2500px", backgroundColor:"#f0f0f5"}}>
                <Divider></Divider>
                <div textAlign="left" style={{overflowX : 'auto', fontSize: '20px', right: "0px", position: "fixed", alignSelf: "flex-end", width:"200px", height:"100px", top:"180px", borderStyle: "solid"}}>
                  Editor Profile
                  <br/> Name : Ahmet Yılmaz
                    </div>
                
                <Container textAlign="center">
                <h1>Recent Requests</h1>
                <Divider/>
                <Tab.Container id="list-group-tabs-example" defaultActiveKey="#link1">
                <Row>
                    <Col sm={4}>
                    <ListGroup>
                        <ListGroup.Item action href="#link1">
                        Request 1
                        </ListGroup.Item>
                        <ListGroup.Item action href="#link2">
                        Request 2
                        </ListGroup.Item>
                        <ListGroup.Item action href="#link3">
                        Request 3
                        </ListGroup.Item>
                        <ListGroup.Item action href="#link4">
                        Request 4
                        </ListGroup.Item>
                        <ListGroup.Item action href="#link5">
                        Request 5
                        </ListGroup.Item>
                        <ListGroup.Item action href="#link6">
                        Request 6
                        </ListGroup.Item>
                    </ListGroup>
                    </Col>
                    <Col sm={8}>
                    <Tab.Content>
                        <Tab.Pane eventKey="#link1">
                            <Container textAlign="left">
                            <p> <strong> App name is: HeadBasket
                                <br/>
                                Developer name is: EGE TURAN
                                <br/>
                                Developer Company is: ADACORP 
                                <br/>
                            Version is: 2.3
                            <br/>
                            Price is: 50TL
                            </strong>
                            </p>
                        <Button color="green">Approve Request</Button>
                        <Button color="red">Reject Request</Button>
                        </Container>
                        </Tab.Pane>
                        <Tab.Pane eventKey="#link2">
                        EGE TURAN 2
                        </Tab.Pane>
                        <Tab.Pane eventKey="#link3">
                        EGE TURAN 3
                        </Tab.Pane>
                        <Tab.Pane eventKey="#link4">
                        EGE TURAN 4 
                        </Tab.Pane>
                        <Tab.Pane eventKey="#link5">
                        EGE TURAN 5 
                        </Tab.Pane>
                        <Tab.Pane eventKey="#link6">
                        EGE TURAN 6
                        </Tab.Pane>
                    </Tab.Content>
                    </Col>
                </Row>
                </Tab.Container>
                </Container>
            </div>

        );


        let requestTest =  (
            <div>
                <AxiosTest></AxiosTest>
            </div>


        );

        let request = ( <div style={{width: "auto", height:"2500px", backgroundColor:"#f0f0f5"}}>
            
                <Container style={{width: "auto", height: "220px", backgroundColor: "white", marginTop: "40px"}}>
                <h1>App to Add</h1>
                <Divider/>
                <h4>Please hold and drag your app into box above </h4>
                <div style={{width: "auto", height: "100px", borderStyle: "solid", borderColor: "blue", backgroundColor:"#f0f0f5"}}>
                Add your app that you want to serve on ADA STORE<Icon name="download" size='huge' style={{marginTop: "20px"}}/>
                
                </div>
                </Container>

                <Container style={{width: "auto", height: "200px", backgroundColor: "white", marginTop: "30px"}}>
                <h1>Release Name</h1>
                <Divider/>
                <h4> Enter App Name, Release Version, and Price  Below </h4>
                <Form>
                    <Form.Group unstackable widths={1}>
                    <Form.Input label='AppName' placeholder='App Name' />
                    <Form.Input label='ReleaseVersion' placeholder='Version' />
                    <Form.Input label='Price' placeholder='price' />
                    </Form.Group>
                </Form>

                </Container>

                <Container style={{width: "auto", height: "100px", backgroundColor: "white", marginTop: "20px"}}>
                <Form.Checkbox label='I agree to the Terms and Conditions' style={{width: "auto", marginTop: "10px"}} />
                <Button color="blue">SUBMIT YOUR REQUEST</Button>
                </Container>
        </div>

        );
        
        let applicationInfo = (

        <div style={{width: "auto", height:"2500px", backgroundColor:"#f0f0f5"}}> 

          <Grid>

          <div textAlign="left" style={{overflowX : 'auto', fontSize: '20px', left: "0px", position: "fixed", alignSelf: "flex-end", width:"300px", height:"500px", top:"120px"}}>
                    <ListGroup>
        <ListGroup.Item style={{background:"green", textColor: "white"}}>Entertainment</ListGroup.Item>
        <ListGroup.Item>Apps</ListGroup.Item>
        <ListGroup.Item>Books</ListGroup.Item>
        <ListGroup.Item>Movies</ListGroup.Item>
        <Divider/>
        <ListGroup.Item>Profile</ListGroup.Item>
        <ListGroup.Item>Settings</ListGroup.Item>
        <Button  onClick={this.displayer.bind(this,
         1)}> Make Request </Button>
         <Button  onClick={this.displayer.bind(this,
         2)}> Make Approvement </Button>
         <Button  onClick={this.displayer.bind(this,
         3)}> Send Request </Button>

        </ListGroup>
            </div>
              
            <Grid.Column style={{width: "780px", height: "2200px", backgroundColor: "white", marginTop: "80px", marginLeft: "360px"}}>
                <Container>
                    <Grid>
                        <Grid.Column style={{width: "120px", height: "120px"}}>
                                <Image  src={whatsapp} style={{width: "150px", height: "150px"}} alt='alt' roundedCircle />
                                    
                        </Grid.Column>
                        <Grid.Column style={{width: "300px", height: "120px", marginLeft: "60px", marginTop: "20px"}}>
                                <h1>Whatsapp Messenger</h1>
                                <h4>Developer Name: Facebook</h4>
                                <h4>Application Version is: 3.15</h4>
                                <h4>Publishing Date: 08/10/2019</h4>
                                <h4>Price: Free</h4>               
                        </Grid.Column>
                        <Grid.Column style={{marginTop: "40px"}}>
                        <Statistic>
                            <Statistic.Label>Rated</Statistic.Label>
                            <Statistic.Value>40,509</Statistic.Value>
                        </Statistic>
                         <Rating maxRating={5} defaultRating={3} icon='star' size='massive' />
                        </Grid.Column>
                        <Button primary="success" style={{width: "180px", height:"50px", marginLeft: "200px", marginTop: "104px"}}>Download</Button>
                        <div style={{marginLeft: "520px", marginTop: "20px"}}>
                                Signed In From: Google<Icon name="warning" /></div>          

                    </Grid>

                    <Container textAlign="center" style={{width:"400px", height:"400px" ,marginTop: "100px"}}>
                    <Carousel>
                    <Carousel.Item>
                        <img
                        className="d-block w-100"
                        src={w1}
                        alt="First slide"
                        />
                        <Carousel.Caption>
                      
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                        className="d-block w-100"
                        src={w2}
                        alt="Third slide"
                        />

                        <Carousel.Caption>
                     
                        </Carousel.Caption>
                    </Carousel.Item>
                    </Carousel>
                    </Container>

                    <Container style={{marginTop: "100px"}}>
                <h1> 
                    Information About Application
                </h1>
                <p>
                WhatsApp Messenger is a freeware, cross-platform messaging and Voice over IP (VoIP) service owned by Facebook,
                <br/> Inc.[43] It allows users to send text messages and voice messages,[44] make voice and video calls, and share images, documents, user locations, <br/> and other media.[45][46] WhatsApp's client application runs on mobile devices but is also accessible  <br/>from desktop computers, as long as the user's mobile device remains connected to the Internet while they use the desktop app.[47] The service requires users to  <br/>provide a standard cellular mobile number for registering with the service.[48] In January 2018, WhatsApp released a standalone business app targeted at small business owners, called WhatsApp Business, to allow companies to communicate with customers who use the standard WhatsApp client.[49][50]

The client application was created by WhatsApp Inc. of Mountain  <br/>View, California, which was acquired by Facebook in February 2014 for approximately US$ 19.3 billion.[51][52] It became the world's most popular messaging application by 2015,[53][54] and has over 1.5 billion users worldwide as of February 2018.[55][53] It has become the primary means of communication in multiple countries, including Brazil, India, Pakistan and large parts of Europe, including the United Kingdom, Spain, and France.[53]
                </p>
                 
                </Container>
                <AppComments></AppComments>
                </Container>
              </Grid.Column>
    

              <Grid.Column style={{width: "240px", height: "2200px", backgroundColor: "white", marginTop: "80px", marginLeft: "40px"}}>
              <h2>Similar Apps</h2>
               
               
              <Container style={{marginTop: "40px"}}>
           
           <Grid>
               <GridColumn>
               <Image  src={whatsapp} style={{width: "50px", height: "50px"}} alt='alt' roundedCircle />
               </GridColumn>
               <GridColumn style={{marginLeft: "40px"}}>
                   <h4>WhatsApp</h4>
                
                   
                   </GridColumn>
           </Grid>

           <h4>Messagin App</h4>

      
           <Divider/>

           <Grid>
               <GridColumn>
               <Image  src={tiktok} style={{width: "50px", height: "50px"}} alt='alt' roundedCircle />
               </GridColumn>
               <GridColumn style={{marginLeft: "40px"}}>
                   <h4>Tiktok</h4>
                
                   
                   </GridColumn>
           </Grid>

           <h4>Video and Entertainment App</h4>

      
           <Divider/>


           <Grid>
               <GridColumn>
               <Image  src={twitter} style={{width: "50px", height: "50px"}} alt='alt' roundedCircle />
               </GridColumn>
               <GridColumn style={{marginLeft: "40px"}}>
                   <h4>Twitter</h4>
                
                   
                   </GridColumn>
           </Grid>

           <h4>Twitting App</h4>

      
           <Divider/>


           <Grid>
               <GridColumn>
               <Image  src={ins} style={{width: "50px", height: "50px"}} alt='alt' roundedCircle />
               </GridColumn>
               <GridColumn style={{marginLeft: "40px"}}>
                   <h4>Instagram</h4>
                
                   
                   </GridColumn>
           </Grid>

           <h4>Photo Sharing App</h4>

      
           <Divider/>
       </Container>

              </Grid.Column>


          </Grid>

        </div>

        );
 
        let endPart = (
            <div>
            <Grid columns="equal" style={{height:"400px", backgroundColor:"gray"}}>
                  <Grid.Column>
                    <div style={{marginLeft:"80px"}}>
                      <p >Our Categories</p>
                      </div>
                    </Grid.Column>
                    <Grid.Column>
                      <p>Contact Us On Social Media</p>
                      <Grid>
                        <div style={{marginTop:"10px"}}>
                        <ButtonSemantic></ButtonSemantic>      
                        </div>
                      </Grid>
                    </Grid.Column>
            </Grid>
            </div>
          );


          let displayer = null;


          if(this.state.showDisplay == 0){
            displayer = applicationInfo;
            console.log(this.state.user);
          }else if(this.state.showDisplay == 1){
              displayer = request;
          }else if(this.state.showDisplay == 2){
                displayer = approveRequest;
          }
          else if(this.state.showDisplay == 3){
            displayer = requestTest;
      }


        return(
            <div>
                {displayer}
                <Divider/>
                {endPart}
            </div>



        );


    };

}

export default ApplicationInformationPage;