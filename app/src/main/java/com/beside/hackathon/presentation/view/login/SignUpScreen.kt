package com.beside.hackathon.presentation.view.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beside.hackathon.core.utils.Colors
import com.beside.hackathon.core.utils.Colors.BG_GREY
import com.beside.hackathon.core.utils.Colors.BUTTON_YELLOW
import com.beside.hackathon.core.utils.Colors.DIVIDER_GRAY
import com.beside.hackathon.core.utils.Constant
import com.beside.hackathon.core.utils.Constant.BORDER_RADIUS
import com.beside.hackathon.core.utils.Constant.DEFAULT_PADDING_H
import com.beside.hackathon.core.utils.TextStyles
import com.beside.hackathon.core.utils.TextStyles.CONTENT_SMALL2_STYLE
import com.beside.hackathon.presentation.component.CustomButton
import com.beside.hackathon.presentation.view.common.DefaultLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController,viewModel: UserViewModel) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var collage by remember { mutableStateOf("") }
    var nickName by remember { mutableStateOf("") }
    var interest by remember { mutableStateOf("") }
    var ageAgree by remember { mutableStateOf(false) }
    var termsAgree by remember { mutableStateOf(false) }
    var privacyAgree by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    DefaultLayout(
        title = "회원가입",
        backButtonOnClick = {
            navController.popBackStack()
        }
    ){
        Column(
            modifier = androidx.compose.ui.Modifier.padding(horizontal = DEFAULT_PADDING_H),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.CenterEnd,
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = DEFAULT_PADDING_H/2),
                    label = { Text("아아디", style = TextStyles.PYEONG_CONTENT2_STLYE) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = DIVIDER_GRAY,
                        unfocusedIndicatorColor = DIVIDER_GRAY,
                    ),
                    singleLine = true,
                    value = id,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.moveFocus(
                            FocusDirection.Next
                        )
                    }),
                    onValueChange = {
                        id = it
                    }
                )
                DuplicateButton(onClick = {

                })
            }
            TextField(

                modifier = Modifier.fillMaxWidth().padding(horizontal = DEFAULT_PADDING_H/2),
                label = { Text("비밀번호", style = TextStyles.PYEONG_CONTENT2_STLYE) },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = DIVIDER_GRAY,
                    unfocusedIndicatorColor = DIVIDER_GRAY,
                    containerColor = Color.Transparent,
                ),
                singleLine = true,
                value = password,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.moveFocus(FocusDirection.Next)
                }),
                onValueChange = {
                    password = it
                }
            )
            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = DEFAULT_PADDING_H/2),
                label = { Text("소속 학교",style = TextStyles.PYEONG_CONTENT2_STLYE) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = DIVIDER_GRAY,
                    unfocusedIndicatorColor = DIVIDER_GRAY,
                ),
                singleLine = true,
                value = collage,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onDone = { focusManager.moveFocus(FocusDirection.Next) }),
                onValueChange = {
                    collage = it
                }
            )
            Box(
                contentAlignment = Alignment.CenterEnd,
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = DEFAULT_PADDING_H/2),
                    label = { Text("닉네임", style = TextStyles.PYEONG_CONTENT2_STLYE) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = DIVIDER_GRAY,
                        unfocusedIndicatorColor = DIVIDER_GRAY,
                    ),
                    singleLine = true,
                    value = nickName,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.moveFocus(
                            FocusDirection.Next
                        )
                    }),
                    onValueChange = {
                        nickName = it
                    }
                )
                DuplicateButton(onClick = {

                })
            }
            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = DEFAULT_PADDING_H/2),
                label = { Text("관심분야",style = TextStyles.PYEONG_CONTENT2_STLYE) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = DIVIDER_GRAY,
                    unfocusedIndicatorColor = DIVIDER_GRAY,
                ),
                singleLine = true,
                value = interest,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onDone = { focusManager.moveFocus(FocusDirection.Next) }),
                onValueChange = {
                    interest = it
                }
            )
            Spacer(modifier = Modifier.height(60.dp))
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ){
                RadioButtonRow(
                    selected = (ageAgree && termsAgree && privacyAgree),
                    onClick = {
                        if(ageAgree && termsAgree && privacyAgree){
                            ageAgree = false
                            termsAgree = false
                            privacyAgree = false
                        }else {
                            ageAgree = true
                            termsAgree = true
                            privacyAgree = true
                        }
                    },
                    title = "전체동의"
                )
                Divider(
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                RadioButtonRow(
                    selected = ageAgree,
                    onClick = {
                        ageAgree = !ageAgree
                    },
                    title = "만 14세 이상입니다."
                )
                RadioButtonRow(
                    selected = termsAgree,
                    onClick = {
                        termsAgree = !termsAgree
                    },
                    title = "이용 약관에 동의합니다."
                )
                RadioButtonRow(
                    selected = privacyAgree,
                    onClick = {
                        privacyAgree = !privacyAgree
                    },
                    title = "개인 정보 수집 및 이용에 동의합니다."
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            CustomButton(onClick = {
                viewModel.signUp(id,password,collage,nickName,interest)
            }) {
                Text("회원가입",style = TextStyles.BUTTON_TEXT_STYLE)
            }
        }
    }
}

@Composable
fun DuplicateButton(onClick : () -> Unit){
    Text(
        "중복확인",
        style = CONTENT_SMALL2_STYLE.copy(
            color = BUTTON_YELLOW
        ),
        modifier = Modifier
            .padding(end = 10.dp)
            .clickable {
                onClick()
            }
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(4.dp)
            )
            .border(
                width = 1.dp,
                color = BUTTON_YELLOW,
                shape = RoundedCornerShape(BORDER_RADIUS)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}

@Preview
@Composable
fun PreviewSignUpScreen(){
    DuplicateButton {

    }
}

@Composable
fun RadioButtonRow(selected: Boolean, onClick: () -> Unit,title:String, content: @Composable () -> Unit = {}){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ){
        RadioButton(
            modifier = Modifier.height(20.dp),
            selected = selected,
            onClick = onClick,
        )
        Text(title,style = TextStyles.CONTENT_SMALL1_STYLE)
        content()
    }
}