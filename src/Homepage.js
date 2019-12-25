import React from 'react';
import AppRenderer from './AppRenderer';
import NavigationAda from './NavigationAda';
import { Container, Grid, Button, Divider } from 'semantic-ui-react';
import whatsapp from './assets/images/whatsapp.png';


class HomePage extends React.Component {
  state = {
    showDisplay: 0
  };



  render(){

    return (

      <div>
          <div style={{width: "auto", height:"2000px", backgroundColor:"white"}}>

            <Container  textAlign="center" style={{width: "1100px", height:"700px", backgroundColor:"gray", marginTop:"50px"}}>
                <Grid>
                    <Grid.Column style={{ width:"270px", height: "600px", marginTop: "20px", backgroundColor:"purple"}}>
           
                            <p>Most Downloaded App This Week</p>
                            <div style={{borderStyle: "solid", background:"white"}}>
                            <img
                            src={whatsapp}
                            alt=""
                            width="220px"
                            height="220px"
                            />
                            </div>

                            <h2>Category: Social</h2>
                            <h4>Whatsapp free messaging app</h4>
                  
                    </Grid.Column>
                    <Grid.Column style={{width:"800px", marginLeft:"10px", marginTop: "20px", backgroundColor:"gray"}}>

                        <Grid style={{width:"800px", marginLeft:"10px"}}>
                            <Grid.Column style={{width:"120px", marginLeft:"10px", marginTop: "20px"}}>
                            <Button style={{backgroundColor:"white"}}>Featured</Button>
                            </Grid.Column>

                            <Grid.Column style={{width:"130px", marginTop: "20px", borderLeft: "1px solid red"}}>
                                <Button style={{backgroundColor:"white"}}>On Sale</Button>
                                </Grid.Column>

                                <Grid.Column style={{width:"150px", marginTop: "20px", borderLeft: "1px solid red"}}>
                                <Button style={{backgroundColor:"white"}}>Best Rated</Button>
                                </Grid.Column>

                        </Grid>
                        <Divider/>

                        <Grid style={{width:"800px", height:"240px", marginLeft:"10px"}}>
                            <Grid.Column style={{width:"230px", marginLeft:"10px", marginTop: "20px", backgroundColor:"green"}}>
                            <Container style={{marginTop: "30px"}}>
                            <img
                            src={whatsapp}
                            alt=""
                            width="100px"
                            height="100px"
                            />
                            </Container>
                            </Grid.Column>

                            <Grid.Column style={{width:"230px", marginLeft:"20px", marginTop: "20px", backgroundColor:"yellow"}}>
                            <Container style={{marginTop: "30px"}}>
                            <img
                            src={whatsapp}
                            alt=""
                            width="100px"
                            height="100px"
                            />
                            </Container>
                                </Grid.Column>
                               
                                <Grid.Column style={{width:"230px", marginLeft:"20px", marginTop: "20px", backgroundColor:"purple"}}>
                                <Divider style={{marginLeft: "120px"}} vertical></Divider>
                                <Container style={{marginTop: "30px"}}>
                            <img
                            src={whatsapp}
                            alt=""
                            width="100px"
                            height="100px"
                            />
                            </Container>
                                </Grid.Column>

                        </Grid>

                        <Grid style={{width:"800px", height:"240px", marginLeft:"10px"}}>
                            <Grid.Column style={{width:"230px", marginLeft:"10px", marginTop: "20px", backgroundColor:"green"}}>
                            <Container style={{marginTop: "30px"}}>
                            <img
                            src={whatsapp}
                            alt=""
                            width="100px"
                            height="100px"
                            />
                            </Container>
                            </Grid.Column>

                            <Grid.Column style={{width:"230px", marginLeft:"20px",  marginTop: "20px", backgroundColor:"yellow"}}>
                            <Container style={{marginTop: "30px"}}>
                            <img
                            src={whatsapp}
                            alt=""
                            width="100px"
                            height="100px"
                            />
                            </Container>
                                </Grid.Column>

                                <Grid.Column style={{width:"230px", marginLeft:"20px", marginTop: "20px", backgroundColor:"purple"}}>
                                <Container style={{marginTop: "30px"}}>
                            <img
                            src={whatsapp}
                            alt=""
                            width="100px"
                            height="100px"
                            />
                            </Container>
                                </Grid.Column>

                        </Grid>
                        
                    </Grid.Column>
                </Grid>
            </Container>

         </div>
        
  
  
  
      </div>
    );
  
  };

}

export default HomePage;
