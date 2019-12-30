import React from 'react';
import { Grid, Container, Divider, Statistic, Form, Button} from 'semantic-ui-react';
import NavigationAda from './NavigationAda';
import HomePage2 from './Homepage2';
import AuthenticatedNavbar from './AuthenticatedNavbar';
import GLOBAL from './global';
import RequestUpload from './RequestUpload';
import MakeApprovement from './MakeApprovement';
import EditorSidebar from './EditorSidebar';
import RateApp from './axios/RateApp';
import GetAppInformation from './axios/GetAppInformation';
import GetMinReq from './axios/GetMinReq';
import GetAppsOnSale from './axios/GetAppsOnSale';
import GetRateApp from './axios/GetRateApp';
import ApproveRequest from './axios/ApproveRequest';
import AddAppWishList from './axios/AddAppWishList';
import GetWishList from './axios/GetWishList';

class AppRenderer extends React.Component{

    state= {
        showDisplay: 0,
        authenticate: 0,
        hashData: "",
        user: null,
        type: 0
    };

    changeScreen(displayOption) {
        this.setState({
            uzmanScreen: displayOption
        });
      }

      componentDidMount(){
        console.log("Type is: " + GLOBAL.typeU);

        if(GLOBAL.userG == null){
            console.log("It is null");
            this.setState({
                authenticate: 0
            });
        }else{
            console.log("User name is: " + GLOBAL.userG.username);
            console.log("It is not null");
            this.setState({
                authenticate: 1,
                user: GLOBAL.userG,
                type: GLOBAL.typeU
            });
        }
      }

      switchNameHandler = (newName) => {

        alert("Logout Successful");
        GLOBAL.userG = null;
        GLOBAL.typeU = 0;
        this.props.history.push("/");

        this.setState({
            authenticate: 0
        });
        
      }

      turnBackFromMakeAppoinment = (newName) => {  
        this.setState({
            showDisplay: 0
          });
      }

      displayer(number) {
        this.setState({
          showDisplay: number
        });
      }


    render(){

        let render = null;
        const greeting = 'Hello Function Component!';

        if(this.state.authenticate == 1){
            if(GLOBAL.typeU == 1){
                render = (
                    <div>
                    <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                    <h1>User Page Will be</h1>
                    <HomePage2></HomePage2>
                 
                    
                    </div>
                );
            }else if(GLOBAL.typeU == 2){
                if(this.state.showDisplay === 1){
                    render = (
                        <div>
                        <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                        <RequestUpload click={this.turnBackFromMakeAppoinment.bind(this, 'EGE')}></RequestUpload>
                        </div>
                    );
                }else{
                render = (
                    <div>
                    <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                    <h1>Developer Page Will be</h1>
                    <Button  onClick={this.displayer.bind(this,
         1)} style={{color: "yellow", backgroundColor: "blue"}}> Make Request </Button>
                    <HomePage2></HomePage2>
                

                    </div>
                );
                    }
            }else if(GLOBAL.typeU == 3){
                if(this.state.showDisplay === 2){
                    render = (
                        <div>
                        <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                        <MakeApprovement click={this.turnBackFromMakeAppoinment.bind(this, 'EGE')} ></MakeApprovement>
                        <HomePage2></HomePage2>
                 
                        </div>
                    );
                }else{
                    render = (
                        <div>
                        <AuthenticatedNavbar click={this.switchNameHandler.bind(this, 'EGE')}> </AuthenticatedNavbar>
                        <h1>Editor Page Will be</h1>
                        <Grid>

    <Grid.Column style={{}}>
    
        <EditorSidebar></EditorSidebar>              
    </Grid.Column>

    <Grid.Column style={{width: "auto", marginLeft: "260px"}}>
    <HomePage2></HomePage2>
    </Grid.Column>
    </Grid>

                   
                        <Button  onClick={this.displayer.bind(this,
         2)} style={{color: "yellow", backgroundColor: "blue"}}> Make Approvement </Button>
                        </div>
                    );
                        }
        
            }else{
                render = (
                    <div>
                    <h1>Unknown Page</h1>
                    </div>
                );
            } 
        }else{
            render = (
                <div>
                <NavigationAda></NavigationAda>
                <h1>Homepage for nonauthentication</h1>
           {/* <RateApp user_id={"10000000"} rate={4.0} app_name={"instagram"} value={greeting}/> */}     
            {/*  <GetAppInformation app_name={"instagram"}/>*/}    
            {/*  <GetMinReq app_id={30}/>*/}  
              {/*   <GetAppsOnSale/> */}  
             {/*   <GetRateApp app_name={"instagram"}/> */} 
               {/*           <ApproveRequest editor_id={30000001} app_id={30}/> */}   
                 {/*            <AddAppWishList user_id={20000000} app_name={"instagram"}/> */} 
                    {/*          <GetWishList user_id={"10000001"}/> */} 
                    <GetWishList user_id={"10000001"}/>

                <HomePage2></HomePage2>
             
                </div>
            );
        }


        return(
            <div>
                {render}


            </div>



        );


    };

}

export default AppRenderer;