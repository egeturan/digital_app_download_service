import React from 'react';
import { Grid, Container, Divider, Statistic, Form, Button, Icon, Rating, GridColumn} from 'semantic-ui-react';
import whatsapp from './assets/images/whatsapp.png';
import ButtonSemantic from './ButtonSemantic.js';
import ListGroup from 'react-bootstrap/ListGroup';
import Image from 'react-bootstrap/Image';
import AppComments from './AppComments';
import Carousel from 'react-bootstrap/Carousel';
import w1 from './assets/images/screenW1.png';
import w2 from './assets/images/screenW2.png';
import twitter from './assets/images/twitter.jpeg';
import ins from './assets/images/ins.jpeg';
import GLOBAL from './global';
import tiktok from './assets/images/tiktok.jpeg';

class ApplicationInformationPage extends React.Component{

    state= {
        showDisplay: 0,
        authenticate: 0,
        user: null
    };

    componentDidMount(){

        console.log(this.props.appP);
        
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
                <Image  src={this.props.appP.image} style={{width: "50px", height: "50px"}} alt='alt' roundedCircle />
                </GridColumn>
                <GridColumn style={{marginLeft: "40px"}}>
                    <h4>WhatsApp</h4>
                 
                    
                    </GridColumn>
            </Grid>

            <h4>Messagin App</h4>

       
            <Divider/>
        </Container>

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
         3)}> Send Request </Button>

        </ListGroup>
            </div>
              
            <Grid.Column style={{width: "780px", height: "2200px", backgroundColor: "white", marginTop: "80px", marginLeft: "360px"}}>
                <Container>
                    <Grid>
                        <Grid.Column style={{width: "120px", height: "120px"}}>
                                <Image  src={this.props.appP.image} style={{width: "150px", height: "150px"}} alt='alt' roundedCircle />
                                    
                        </Grid.Column>
                        <Grid.Column style={{width: "300px", height: "120px", marginLeft: "60px", marginTop: "20px"}}>
                                <h1>{this.props.appP.appName}</h1>
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