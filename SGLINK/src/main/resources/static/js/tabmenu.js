let tabHeader1 = document.getElementsByClassName("tab-header")[0];
let tabIndicator1 = document.getElementsByClassName("tab-indicator")[0];
let tabBody1 = document.getElementsByClassName("tab-body")[0];

let tabsPane1 = tabHeader1.getElementsByTagName("div");

for(let i=0;i<tabsPane1.length;i++){
  tabsPane1[i].addEventListener("click",function(){
    tabHeader1.getElementsByClassName("active")[0].classList.remove("active");
    tabsPane1[i].classList.add("active");
    tabBody1.getElementsByClassName("active")[0].classList.remove("active");
    tabBody1.getElementsByTagName("div")[i].classList.add("active");
    
    tabIndicator1.style.left = `calc(calc(100% / 4) * ${i})`;
  });
}