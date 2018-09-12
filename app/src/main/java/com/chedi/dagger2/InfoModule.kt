package com.chedi.dagger2

import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope
import javax.inject.Singleton

// This @Module is used just like a bag, used to store a repository of provided object for Injection.
// So I’m going to store my Info provider in it
// The class InfoModule is annotated with @Module, and that tells Dagger 2 this is where we stores the @Provides functions within.
// Open is used to inherit the module and create class for tests
@CreateOnce
@Module
open class InfoModule {

    // This function is it is not called anywhere in the application code.
    // It is another magic that Dagger 2 does and hook them up internally.
    // We use @Provides to ask dagger2 to provide our Info
    @Provides @Choose(CHEDI)
    open fun providesInfo(): Info {
        return Info("Chedi")
    }

    // We can use @Named instead of our custom annotation @Choose :
    // @Provides @Named(DAGGER)
    @Provides @Choose(DAGGER)
    open fun providesOtherInfo(): Info {
        return Info("Dagger2 by")
    }
}

// See documentation :3 i'm not your teacher
@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class Choose(val value: String = "")

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class CreateOnce